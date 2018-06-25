package com.summer.kotlineyepetizer.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.bean.Banner
import me.drakeet.multitype.ItemViewBinder

class BannerAdapter : ItemViewBinder<Banner.IssueListBean.ItemListBean, BannerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): BannerAdapter.ViewHolder {
        var view: View = inflater.inflate(R.layout.item_banner, parent, false)
        Log.e("BannerAdapter","onCreateViewHolder")
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var item: Banner.IssueListBean.ItemListBean? = null
        private var tvTitle: TextView? = null

        init {
            tvTitle = view.findViewById(R.id.tvTitle)
            Log.e("BannerAdapter","init")

        }

        fun setData(item: Banner.IssueListBean.ItemListBean) {
            this.item = item
            tvTitle?.text = item?.data?.title
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, item: Banner.IssueListBean.ItemListBean) {
        holder.setData(item)
        Log.e("BannerAdapter","onBindViewHolder")
    }

}
