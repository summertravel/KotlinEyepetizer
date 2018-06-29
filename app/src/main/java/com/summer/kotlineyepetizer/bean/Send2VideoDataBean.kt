package com.summer.kotlineyepetizer.bean

import java.io.Serializable


data class Send2VideoDataBean(
        val id: String,
        val playUrl: String,
        val bgPic: String,
        val title: String,
        val description: String,
        val authorName: String,
        val authorDescription: String,
        val collectionCount: String,
        val shareCount: String,
        val replyCount: String,
        val authorIcon: String,
        val tagList: ArrayList<Tag>) : Serializable

