package com.summer.kotlineyepetizer.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.summer.kotlineyepetizer.GlideApp
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.WebActivity
import com.summer.kotlineyepetizer.bean.Message
import com.summer.kotlineyepetizer.config.Constant
import java.util.*

class GuanfangAdapter(val context: Context, var dataList: ArrayList<Message>) : RecyclerView.Adapter<GuanfangAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuanfangAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_guanfang, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle: TextView = view.findViewById(R.id.tv_title)
        val tvContent: TextView = view.findViewById(R.id.tv_content)
        val ivPic: ImageView = view.findViewById(R.id.iv_pic)
        val tvDate: TextView = view.findViewById(R.id.tv_date)
        var message: Message? = null

        init {
            view.setOnClickListener {
                val intent = Intent(view.context, WebActivity::class.java)
                intent.putExtra(Constant.DATA, message?.actionUrl)
                view.context.startActivity(intent)
            }
        }

        fun setData(message: Message) {
            this.message = message
            tvTitle.text = message.title
            tvContent.text = message.content
            tvDate.text = calDate(message.date).toString() + "天前"
            GlideApp.with(view).load(message.icon).into(ivPic)
        }

        fun calDate(date: Long): Int {
            var l = Date().time - date
            return Math.floor((l / 86400000).toDouble()).toInt()
        }
    }

}
