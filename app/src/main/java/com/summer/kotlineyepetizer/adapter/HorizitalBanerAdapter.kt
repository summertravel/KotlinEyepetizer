package com.summer.kotlineyepetizer.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.summer.kotlineyepetizer.GlideApp
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.activity.VideoActivity
import com.summer.kotlineyepetizer.bean.Banner
import com.summer.kotlineyepetizer.bean.Issue
import com.summer.kotlineyepetizer.bean.Item
import com.summer.kotlineyepetizer.config.Constant
import com.summer.kotlineyepetizer.util.DisplayUtil
import org.jetbrains.anko.startActivity

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
            intent.putExtra(Constant.DATA, dataList[position].data)
            ctx.startActivity(intent)
        }
        holder.tvPage?.text = (position + 1).toString() + "/" + dataList.size
        holder.tvSlogan?.text = dataList[position].data.slogan
        Glide.with(ctx).load(dataList[position].data.cover.detail).into(holder.ivPic!!)
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

