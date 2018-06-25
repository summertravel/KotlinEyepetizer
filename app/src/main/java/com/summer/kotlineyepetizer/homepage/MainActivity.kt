package com.summer.kotlineyepetizer.homepage

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.adapter.BannerAdapter
import com.summer.kotlineyepetizer.base.BaseActivity
import com.summer.kotlineyepetizer.bean.Banner
import com.summer.kotlineyepetizer.bean.RecommendBean
import kotlinx.android.synthetic.main.activity_main.*
import me.drakeet.multitype.Items
import me.drakeet.multitype.MultiTypeAdapter
import me.drakeet.multitype.register
import kotlin.math.log

class MainActivity : BaseActivity(), HomeContract.View {

    val squareCardCollection: String = "squareCardCollection"
    val textCard: String = "textCard"
    val banner2: String = "banner2"

    private var items: Items? = null
    private var multiTypeAdapter: MultiTypeAdapter? = null
    private var mPresenter: HomePresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        items = Items()
        recyclerView.layoutManager = LinearLayoutManager(MainActivity@this)
        multiTypeAdapter = MultiTypeAdapter()
        multiTypeAdapter!!.register(Banner.IssueListBean.ItemListBean::class.java, BannerAdapter())
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
        Log.e("maina", dataList.size.toString())
        items!!.addAll(dataList)
        multiTypeAdapter!!.notifyDataSetChanged()
    }
}



