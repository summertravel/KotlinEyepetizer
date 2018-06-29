package com.summer.kotlineyepetizer.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.summer.kotlineyepetizer.GlideApp
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.bean.MaybeULike
import me.drakeet.multitype.ItemViewBinder

class VideoOfListHeadAdpter : ItemViewBinder<MaybeULike.Item.Data, VideoOfListHeadAdpter.ViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_video_head, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: MaybeULike.Item.Data) {
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

        fun setData(item: MaybeULike.Item.Data) {
            tvTilte.text = item.content.data.title
            tvDesc.text = item.content.data.description
            tvAuthor.text = item.content.data.author.name
            tvAuthorDesc.text = item.content.data.author.description
            tvFavorites.text = item.content.data.consumption.collectionCount.toString()
            tvShare.text = item.content.data.consumption.shareCount.toString()
            tvReplyCount.text = item.content.data.consumption.replyCount.toString()

            GlideApp.with(itemView.context).load(item.content.data.author.icon).circleCrop().into(ivAuthor)
        }

    }
}