package com.summer.kotlineyepetizer.homepage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.adapter.BannerAdapter
import com.summer.kotlineyepetizer.adapter.ListAdapter
import com.summer.kotlineyepetizer.bean.Banner
import com.summer.kotlineyepetizer.bean.Issue
import com.summer.kotlineyepetizer.bean.MaybeULike
import kotlinx.android.synthetic.main.fragment_home.*
import me.drakeet.multitype.Items
import me.drakeet.multitype.MultiTypeAdapter
import com.summer.kotlineyepetizer.GlideApp
import com.summer.kotlineyepetizer.bean.CategoriesBean


class HomeListFragment : Fragment(), HomeContract.View {
    var rootView: View? = null

    override fun showData(bean: Banner, uLike: MaybeULike) {

        var dataList = bean.issueList[0].itemList
        bean.issueList[0].itemList.filter { it -> it.type != "video" }.forEach { it ->
            dataList.remove(it)
        }
        items!!.add(bean.issueList[0])
        uLike.itemList.filter { it -> it.type != "followCard" }.forEach { it ->
            uLike.itemList.remove(it)
        }
        items!!.addAll(uLike.itemList)
        multiTypeAdapter!!.notifyDataSetChanged()
    }

    override fun showLoading(s: String) {
    }

    override fun dismissLoading() {
    }

    private var items: Items? = null
    private var multiTypeAdapter: MultiTypeAdapter? = null
    private var mPresenter: HomePresenter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_home_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        items = Items()
        recyclerView.layoutManager = LinearLayoutManager(context)
        multiTypeAdapter = MultiTypeAdapter()
        multiTypeAdapter!!.register(Issue::class.java, BannerAdapter())
        multiTypeAdapter!!.register(MaybeULike.Item::class.java, ListAdapter(this))
        recyclerView.adapter = multiTypeAdapter
        multiTypeAdapter!!.items = items as Items
        mPresenter = HomePresenter(this)
        mPresenter?.getData()
    }

    override fun onStop() {
        GlideApp.get(context!!).clearMemory()
        super.onStop()
    }

}