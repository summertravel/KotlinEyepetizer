package com.summer.kotlineyepetizer.homepage

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.adapter.BannerAdapter
import com.summer.kotlineyepetizer.base.BaseActivity
import com.summer.kotlineyepetizer.bean.Banner
import com.summer.kotlineyepetizer.bean.Issue
import kotlinx.android.synthetic.main.activity_main.*
import me.drakeet.multitype.Items
import me.drakeet.multitype.MultiTypeAdapter

class MainActivity : BaseActivity(), HomeContract.View {
    private var items: Items? = null
    private var multiTypeAdapter: MultiTypeAdapter? = null
    private var mPresenter: HomePresenter? = null

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = Items()
        recyclerView.layoutManager = LinearLayoutManager(this)
        multiTypeAdapter = MultiTypeAdapter()
        multiTypeAdapter!!.register(Issue::class.java, BannerAdapter())
        recyclerView.adapter = multiTypeAdapter
        multiTypeAdapter!!.items = items as Items
        mPresenter = HomePresenter(this)
        mPresenter?.getData()
    }

    override fun showData(bean: Banner) {
        var dataList = bean.issueList[0].itemList
        bean.issueList[0].itemList.filter { it -> it.type != "video" }.forEach { it ->
            dataList.remove(it)
        }
        items!!.add(bean.issueList[0])
        multiTypeAdapter!!.notifyDataSetChanged()
    }
}



