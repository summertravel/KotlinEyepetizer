package com.summer.kotlineyepetizer.adapter

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.summer.kotlineyepetizer.GlideApp
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.video.VideoActivity
import com.summer.kotlineyepetizer.bean.MaybeULike
import com.summer.kotlineyepetizer.bean.Send2VideoDataBean
import com.summer.kotlineyepetizer.bean.Tag
import com.summer.kotlineyepetizer.config.Constant
import com.transitionseverywhere.Crossfade
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import me.drakeet.multitype.ItemViewBinder
import android.animation.ObjectAnimator



class ListAdapter(var context: Fragment) : ItemViewBinder<MaybeULike.Item, ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: MaybeULike.Item) {
        holder.setData(item, context)
    }

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle: TextView? = null
        var tvDesc: TextView? = null
        var ivPic: ImageView? = null
        var ivAuthor: ImageView? = null
        var item: MaybeULike.Item? = null

        init {
            tvTitle = view.findViewById(R.id.tv_title)
            tvDesc = view.findViewById(R.id.tv_desc)
            ivPic = view.findViewById(R.id.iv_pic)
            ivAuthor = view.findViewById(R.id.iv_author)
            view.setOnClickListener {
                var intent = Intent(view?.context, VideoActivity::class.java)
                var tagList: ArrayList<Tag> = item?.data?.content?.data?.tags!!

                val videoDataBean = Send2VideoDataBean(
                        item?.data?.header?.id.toString()!!,
                        item?.data?.content?.data?.playUrl!!,
                        item?.data?.content?.data?.cover?.blurred!!,
                        item?.data?.content?.data?.title!!,
                        item?.data?.content?.data?.description!!,
                        item?.data?.content?.data?.author?.name!!,
                        item?.data?.content?.data?.author?.description!!,
                        item?.data?.content?.data?.consumption?.collectionCount.toString(),
                        item?.data?.content?.data?.consumption?.shareCount.toString(),
                        item?.data?.content?.data?.consumption?.replyCount.toString(),
                        item?.data?.content?.data?.author?.icon!!,
                        tagList)
                intent.putExtra(Constant.DATA, videoDataBean)
                val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(view.context as Activity, ivPic!!, "image")
                view?.context?.startActivity(intent, optionsCompat.toBundle())
            }
        }


        fun setData(item: MaybeULike.Item, context: Fragment?) {
            this.item = item
            GlideApp.with(context!!).load(item.data.content.data.cover.detail)
                    .skipMemoryCache(true)
                    .transition(withCrossFade(1000))
                    .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(15, 0)))
                    .into(ivPic!!)
            GlideApp.with(context!!).load(item.data.content.data.author.icon).circleCrop().into(ivAuthor!!)
            tvTitle!!.text = item.data.content.data.title
            tvDesc!!.text = item.data.header.title + item.data.header.description
        }

    }
}