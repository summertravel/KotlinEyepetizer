package com.summer.kotlineyepetizer.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.summer.kotlineyepetizer.GlideApp
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.bean.Data
import me.drakeet.multitype.ItemViewBinder

class VideoHeadAdpter : ItemViewBinder<Data, VideoHeadAdpter.ViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_video_head, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: Data) {
        holder.setData(item)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         var tvTilte: TextView = view.findViewById(R.id.tv_title)
         var tvDesc: TextView= view.findViewById(R.id.tv_desc)
         var tvAuthor: TextView = view.findViewById(R.id.tv_author)
         var tvAuthorDesc: TextView = view.findViewById(R.id.tv_author_desc)
         var ivAuthor: ImageView = view.findViewById(R.id.iv_author)
         var tvFavorites: TextView = view.findViewById(R.id.tv_favorites)
         var tvShare: TextView = view.findViewById(R.id.tv_share)
         var tvReplyCount: TextView = view.findViewById(R.id.tv_reply_count)

        fun setData(item: Data) {
            tvTilte.text = item.title
            tvDesc.text = item.description
            tvAuthor.text = item.author.name
            tvAuthorDesc.text = item.author.description
            tvFavorites.text = item.consumption.collectionCount.toString()
            tvShare.text = item.consumption.shareCount.toString()
            tvReplyCount.text = item.consumption.replyCount.toString()

            GlideApp.with(itemView.context).load(item.author.icon).circleCrop().into(ivAuthor)
        }

    }
}