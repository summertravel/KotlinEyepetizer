package com.summer.kotlineyepetizer.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.request.RequestOptions
import com.summer.kotlineyepetizer.GlideApp
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.bean.Item
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import me.drakeet.multitype.ItemViewBinder

class VideoAdpter : ItemViewBinder<Item, VideoAdpter.ViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_video_related, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: Item) {
        holder.setData(item)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
        val tvDesc: TextView = view.findViewById(R.id.tv_desc)
        val ivPic: ImageView = view.findViewById(R.id.iv_pic)
        fun setData(item: Item) {
            tvTitle.text = item.data.title
            tvDesc.text = "#" + item.data.category
            GlideApp.with(view.context).load(item.data.cover.detail)
                    .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(15, 0)))
                    .into(ivPic)
        }

    }
}