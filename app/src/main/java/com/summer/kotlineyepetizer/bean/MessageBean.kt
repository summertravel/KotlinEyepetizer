package com.summer.kotlineyepetizer.bean


data class MessageBean(
        var messageList: ArrayList<Message>,
        var updateTime: Long,
        var nextPageUrl: Any
)

data class Message(
        var id: Int,
        var title: String,
        var content: String,
        var date: Long,
        var actionUrl: String,
        var icon: String,
        var ifPush: Boolean,
        var pushStatus: Int,
        var uid: Any
)