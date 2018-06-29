package com.summer.kotlineyepetizer.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.bean.Banner
import me.drakeet.multitype.ItemViewBinder
import android.support.v7.widget.PagerSnapHelper
import com.summer.kotlineyepetizer.bean.Issue


class BannerAdapter : ItemViewBinder<Issue, BannerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): BannerAdapter.ViewHolder {
        var view: View = inflater.inflate(R.layout.item_recycle, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, item: Issue) {
        holder.setData(item)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var item: Issue? = null
        private var recyclerView: RecyclerView? = null

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            recyclerView?.layoutManager = LinearLayoutManager(recyclerView?.context, RecyclerView.HORIZONTAL, false)
            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)
        }

        fun setData(item: Issue) {
            this.item = item
            recyclerView?.adapter = HorizitalBanerAdapter(recyclerView!!.context, item.itemList)
        }

    }
}


