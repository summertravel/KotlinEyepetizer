package com.summer.kotlineyepetizer.gaunzhu

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.adapter.DynamicInfoCardListAdapter
import com.summer.kotlineyepetizer.adapter.ListAdapter
import com.summer.kotlineyepetizer.bean.DynamicInfoCardBean
import com.summer.kotlineyepetizer.bean.MaybeULike
import kotlinx.android.synthetic.main.fragment_zuopin.*
import me.drakeet.multitype.Items
import me.drakeet.multitype.MultiTypeAdapter

class GuanzhuListFragment : Fragment(), GuanzhuListContract.View {

    companion object {
        fun getInstance(index: Int, apiUrl: String): GuanzhuListFragment {
            val fragment = GuanzhuListFragment()
            val bundle = Bundle()
            bundle.putString("url", apiUrl)
            bundle.putInt("index", index)
            fragment.arguments = bundle
            return fragment
        }
    }

    private var items: Items? = null
    private var multiTypeAdapter: MultiTypeAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_zuopin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiUrl = arguments!!["url"] as String
        val index = arguments!!["index"] as Int
        items = Items()
        recyclerView.layoutManager = LinearLayoutManager(context)
        multiTypeAdapter = MultiTypeAdapter()
        if (index == 0)
            multiTypeAdapter!!.register(MaybeULike.Item::class.java, ListAdapter(this))
        else
            multiTypeAdapter!!.register(DynamicInfoCardBean.Item::class.java, DynamicInfoCardListAdapter(this))
        multiTypeAdapter!!.items = items as Items
        recyclerView.adapter = multiTypeAdapter
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