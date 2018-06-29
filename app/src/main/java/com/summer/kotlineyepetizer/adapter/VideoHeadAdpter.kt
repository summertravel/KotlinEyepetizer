package com.summer.kotlineyepetizer.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.summer.kotlineyepetizer.GlideApp
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.bean.Data
import com.summer.kotlineyepetizer.bean.Send2VideoDataBean
import me.drakeet.multitype.ItemViewBinder

class VideoHeadAdpter : ItemViewBinder<Send2VideoDataBean, VideoHeadAdpter.ViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_video_head, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: Send2VideoDataBean) {
        holder.setData(item)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvTilte: TextView = view.findViewById(R.id.tv_title)
        var tvDesc: TextView = view.findViewById(R.id.tv_desc)
        var tvAuthor: TextView = view.findViewById(R.id.tv_author)
        var tvAuthorDesc: TextView = view.findViewById(R.id.tv_author_desc)
        var ivAuthor: ImageView = view.findViewById(R.id.iv_author)
        var tvFavorites: TextView = view.findViewById(R.id.tv_favorites)
        var tvShare: TextView = view.findViewById(R.id.tv_share)
        var tvReplyCount: TextView = view.findViewById(R.id.tv_reply_count)
        var ivTag1: ImageView = view.findViewById(R.id.iv_tag1)
        var ivTag2: ImageView = view.findViewById(R.id.iv_tag2)
        var ivTag3: ImageView = view.findViewById(R.id.iv_tag3)
        var tvTag1: TextView = view.findViewById(R.id.tv_tag1)
        var tvTag2: TextView = view.findViewById(R.id.tv_tag2)
        var tvTag3: TextView = view.findViewById(R.id.tv_tag3)

        fun setData(item: Send2VideoDataBean) {
            tvTilte.text = item.title
            tvDesc.text = item.description
            tvAuthor.text = item.authorName
            tvAuthorDesc.text = item.authorDescription
            tvFavorites.text = item.collectionCount
            tvShare.text = item.shareCount
            tvReplyCount.text = item.replyCount
            tvTag1.text = item.tagList[0].name
            tvTag2.text = item.tagList[1].name
            tvTag3.text = item.tagList[2].name

            GlideApp.with(itemView.context).load(item.authorIcon).circleCrop().into(ivAuthor)
            GlideApp.with(itemView.context).load(item.tagList[0].bgPicture).into(ivTag1)
            GlideApp.with(itemView.context).load(item.tagList[1].bgPicture).into(ivTag2)
            GlideApp.with(itemView.context).load(item.tagList[2].bgPicture).into(ivTag3)
        }

    }
}