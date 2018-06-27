package com.summer.kotlineyepetizer.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.summer.kotlineyepetizer.GlideApp
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.adapter.VideoHeadAdpter
import com.summer.kotlineyepetizer.adapter.VideoRelationAdpter
import com.summer.kotlineyepetizer.base.BaseActivity
import com.summer.kotlineyepetizer.bean.Banner
import com.summer.kotlineyepetizer.bean.Data
import com.summer.kotlineyepetizer.config.Constant
import kotlinx.android.synthetic.main.activity_video.*
import me.drakeet.multitype.Items
import me.drakeet.multitype.MultiTypeAdapter

class VideoActivity : BaseActivity() {
    lateinit var adapter: MultiTypeAdapter
    override fun getLayout(): Int {
        return R.layout.activity_video
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var data = intent.getSerializableExtra(Constant.DATA) as Data
        videoPlayer.setUpLazy(data.playUrl, true, null, null,"")
        videoPlayer.startButton.performClick()
        videoPlayer.fullscreenButton.setOnClickListener {
            videoPlayer.startWindowFullscreen(this, false, true)
        }
        videoPlayer.backButton.setOnClickListener { finish() }
        adapter = MultiTypeAdapter()
//        adapter.register(Banner.IssueListBean.ItemListBean.DataBean::class.java)
//                .to(VideoHeadAdpter(), VideoHeadAdpter())
//                .withLinker { position, t -> if (position == 0) 0 else 1 }
        adapter.register(Data::class.java,VideoHeadAdpter())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        GlideApp.with(this).load(data.cover.blurred).into(object : SimpleTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                recyclerView.background = resource
            }
        })
        var items = Items()
        items.add(data)
        adapter.items =  items
        adapter.notifyDataSetChanged()
    }

}
