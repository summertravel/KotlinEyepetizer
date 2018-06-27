package com.summer.kotlineyepetizer.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.bean.Banner
import com.summer.kotlineyepetizer.bean.Data
import me.drakeet.multitype.ItemViewBinder

class VideoRelationAdpter: ItemViewBinder<Data, VideoRelationAdpter.ViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_video_relation,parent))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: Data) {
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){

    }
}