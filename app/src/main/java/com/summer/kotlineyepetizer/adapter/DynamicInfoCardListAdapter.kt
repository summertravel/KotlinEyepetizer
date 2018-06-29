package com.summer.kotlineyepetizer.adapter

import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.summer.kotlineyepetizer.GlideApp
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.bean.DynamicInfoCardBean
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import me.drakeet.multitype.ItemViewBinder

class DynamicInfoCardListAdapter(var context: Fragment) : ItemViewBinder<DynamicInfoCardBean.Item, DynamicInfoCardListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: DynamicInfoCardBean.Item) {
        holder.setData(item, context)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle: TextView? = null
        var tvDesc: TextView? = null
        var ivPic: ImageView? = null
        var ivAuthor: ImageView? = null
        var item: DynamicInfoCardBean.Item? = null

        init {
            tvTitle = view.findViewById(R.id.tv_title)
            tvDesc = view.findViewById(R.id.tv_desc)
            ivPic = view.findViewById(R.id.iv_pic)
            ivAuthor = view.findViewById(R.id.iv_author)
            view.setOnClickListener {

            }
        }


        fun setData(item: DynamicInfoCardBean.Item, context: Fragment?) {
            this.item = item
            GlideApp.with(context!!).load(item.data.simpleVideo.cover.detail).skipMemoryCache(true).transform(RoundedCornersTransformation(10, 5)).into(ivPic!!)
            GlideApp.with(context!!).load(item.data.user.avatar).circleCrop().into(ivAuthor!!)
            tvTitle!!.text = item.data.simpleVideo.title
            tvDesc!!.text = item.data.simpleVideo.title + item.data.simpleVideo.description
        }

    }
}