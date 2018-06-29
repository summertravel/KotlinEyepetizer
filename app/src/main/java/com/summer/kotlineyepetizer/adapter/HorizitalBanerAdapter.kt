package com.summer.kotlineyepetizer.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.summer.kotlineyepetizer.GlideApp
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.video.VideoActivity
import com.summer.kotlineyepetizer.bean.*
import com.summer.kotlineyepetizer.config.Constant
import com.summer.kotlineyepetizer.util.DisplayUtil
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class HorizitalBanerAdapter(var ctx: Context, private var dataList: ArrayList<Item>) : Adapter<HorizitalBanerAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(ctx).inflate(R.layout.item_banner, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvTitle?.text = dataList[position].data.title
        var params = holder.ivPic?.layoutParams
        params?.height = DisplayUtil.getDensityWdith(ctx) / 2
        holder.ivPic!!.layoutParams = params
        holder.ivPic?.setOnClickListener {
            var intent = Intent(ctx, VideoActivity::class.java)
            var tagList: ArrayList<Tag> = dataList[position]?.data?.tags!!
            val videoDataBean = Send2VideoDataBean(
                    dataList[position]?.data?.id.toString()!!,
                    dataList[position]?.data?.playUrl,
                    dataList[position]?.data?.cover.blurred,
                    dataList[position]?.data?.title,
                    dataList[position]?.data?.description,
                    dataList[position]?.data?.author.name,
                    dataList[position]?.data?.author.description,
                    dataList[position]?.data?.consumption.collectionCount.toString(),
                    dataList[position]?.data?.consumption.shareCount.toString(),
                    dataList[position]?.data?.consumption.replyCount.toString(),
                    dataList[position]?.data?.author.icon,
                    tagList)
            intent.putExtra(Constant.DATA, videoDataBean)
            val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(ctx as Activity, holder.ivPic!!, "image")
            ctx.startActivity(intent, optionsCompat.toBundle())
        }
        holder.tvPage?.text = (position + 1).toString() + "/" + dataList.size
        holder.tvSlogan?.text = dataList[position].data.slogan
        GlideApp.with(ctx).load(dataList[position].data.cover.detail).skipMemoryCache(true).transform(RoundedCornersTransformation(15, 5)).into(holder.ivPic!!)
        GlideApp.with(ctx).load(dataList[position].data.author.icon).circleCrop().into(holder.ivAuthor!!)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivPic: ImageView? = null
        var ivAuthor: ImageView? = null
        var tvTitle: TextView? = null
        var tvPage: TextView? = null
        var tvSlogan: TextView? = null

        init {
            ivPic = view.findViewById(R.id.iv_pic)
            tvTitle = view.findViewById(R.id.tv_title)
            tvPage = view.findViewById(R.id.tv_page)
            tvSlogan = view.findViewById(R.id.tv_slogan)
            ivAuthor = view.findViewById(R.id.iv_author)
        }
    }
}

