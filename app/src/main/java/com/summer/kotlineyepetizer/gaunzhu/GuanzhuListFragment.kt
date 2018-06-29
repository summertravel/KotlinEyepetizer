package com.summer.kotlineyepetizer.gaunzhu

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.R.id.recyclerView
import com.summer.kotlineyepetizer.adapter.DynamicInfoCardListAdapter
import com.summer.kotlineyepetizer.adapter.ListAdapter
import com.summer.kotlineyepetizer.bean.DynamicInfoCardBean
import com.summer.kotlineyepetizer.bean.MaybeULike
import kotlinx.android.synthetic.main.fragment_home.*
import me.drakeet.multitype.Items
import me.drakeet.multitype.MultiTypeAdapter

@SuppressLint("ValidFragment")
class GuanzhuListFragment(var index: Int, val apiUrl: String) : Fragment(), GuanzhuListContract.View {

    private var items: Items? = null
    private var multiTypeAdapter: MultiTypeAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_zuopin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        items = Items()
        recyclerView.layoutManager = LinearLayoutManager(context)
        multiTypeAdapter = MultiTypeAdapter()
        if (index == 0)
            multiTypeAdapter!!.register(MaybeULike.Item::class.java, ListAdapter(this))
        else
            multiTypeAdapter!!.register(DynamicInfoCardBean.Item::class.java, DynamicInfoCardListAdapter(this))
        recyclerView.adapter = multiTypeAdapter
        multiTypeAdapter!!.items = items as Items
        GuanZhuListPresenter(index, this, apiUrl).getData()
    }

    override fun showData(dataList: ArrayList<MaybeULike.Item>) {
        items?.addAll(dataList)
        multiTypeAdapter?.notifyDataSetChanged()
    }

    override fun showDynamicInfoCardBeanData(dataList: ArrayList<DynamicInfoCardBean.Item>) {
        items?.addAll(dataList)
        multiTypeAdapter?.notifyDataSetChanged()
    }


    override fun showLoading(s: String) {
    }

    override fun dismissLoading() {
    }
}