package com.summer.kotlineyepetizer.video

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.summer.kotlineyepetizer.GlideApp
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.adapter.VideoAdpter
import com.summer.kotlineyepetizer.adapter.VideoHeadAdpter
import com.summer.kotlineyepetizer.base.BaseActivity
import com.summer.kotlineyepetizer.bean.Issue
import com.summer.kotlineyepetizer.bean.Item
import com.summer.kotlineyepetizer.bean.Send2VideoDataBean
import com.summer.kotlineyepetizer.config.Constant
import kotlinx.android.synthetic.main.activity_video.*
import me.drakeet.multitype.Items
import me.drakeet.multitype.MultiTypeAdapter

class VideoActivity : BaseActivity(), VideoContact.View {

    lateinit var adapter: MultiTypeAdapter
    var items: Items? = null

    override fun getLayout(): Int {
        return R.layout.activity_video
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var data = intent.getSerializableExtra(Constant.DATA) as Send2VideoDataBean
        videoPlayer.setUpLazy(data.playUrl, true, null, null, "")
        videoPlayer.startButton.performClick()
        videoPlayer.fullscreenButton.setOnClickListener {
            videoPlayer.startWindowFullscreen(this, false, true)
        }
        videoPlayer.backButton.setOnClickListener { finish() }
        adapter = MultiTypeAdapter()
//        adapter.register(Banner.IssueListBean.ItemListBean.DataBean::class.java)
//                .to(VideoHeadAdpter(), VideoHeadAdpter())
//                .withLinker { position, t -> if (position == 0) 0 else 1 }
        adapter.register(Send2VideoDataBean::class.java, VideoHeadAdpter())
        adapter.register(Item::class.java, VideoAdpter())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        GlideApp.with(this).load(data.bgPic).into(object : SimpleTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                recyclerView.background = resource
            }
        })
        items = Items()
        items?.add(data)
        adapter.items = items as Items
        adapter.notifyDataSetChanged()
        VideoPresenter(this, data.id).getData()
    }

    override fun showData(dataList: ArrayList<Item>) {
        dataList.filter { it -> it.type != "videoSmallCard" }.forEach { it -> dataList.remove(it) }
        items?.addAll(dataList)
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        videoPlayer.setVideoAllCallBack(null)
        GSYVideoManager.releaseAllVideos()
    }
}
