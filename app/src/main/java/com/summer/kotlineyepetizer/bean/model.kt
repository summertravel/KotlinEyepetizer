package com.summer.kotlineyepetizer.bean


data class Categories(
		var id: Int,// 24
		var name: String,// 时尚
		var alias: String,
		var description: String,// 优雅地行走在潮流尖端
		var bgPicture: String,// http://img.kaiyanapp.com/22192a40de238fe853b992ed57f1f098.jpeg
		var bgColor: String,//
		var headerImage: String,// http://img.kaiyanapp.com/c9b19c2f0a2a40f4c45564dd8ea766d3.png
		var defaultAuthorId: Int// 2160
)


data class AuthorDetail(
		var tabInfo: TabInfo,
		var pgcInfo: PgcInfo
)

data class TabInfo(
		var tabList: ArrayList<Tab>,
		var defaultIdx: Int// 0
)

data class Tab(
		var id: Int,// 0
		var name: String,// 首页
		var apiUrl: String// http://baobab.kaiyanapp.com/api/v4/pgcs/detail/index?id=1140
)

data class PgcInfo(
		var dataType: String,// PgcInfo
		var id: Int,// 1140
		var icon: String,// http://img.kaiyanapp.com/757c4fa026bb6a8eb8034f4ec617d879.jpeg?imageMogr2/quality/60/format/jpg
		var name: String,// CG Meetup
		var brief: String,// 222 个视频 / 28880 次收藏 / 16519 次分享
		var description: String,// 精彩 CG 动画短片，让你大开眼界，灵感迸发。
		var actionUrl: String,// eyepetizer://pgc/detail/1140/?title=CG%20Meetup&userType=PGC&tabIndex=1
		var area: String,//
		var gender: String,//
		var registDate: Int,// -1
		var followCount: Int,// 7558
		var follow: Follow,
		var self: Boolean,// false
		var cover: String,
		var videoCount: Int,// 222
		var shareCount: Int,// 16519
		var collectCount: Int,// 28880
		var myFollowCount: Int,// 0
		var videoCountActionUrl: String,
		var myFollowCountActionUrl: String,
		var followCountActionUrl: String,
		var shield: Shield
)

data class Follow(
		var itemType: String,// author
		var itemId: Int,// 1140
		var followed: Boolean// false
)

data class Shield(
		var itemType: String,// author
		var itemId: Int,// 1140
		var shielded: Boolean// false
)


