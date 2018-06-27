package com.summer.kotlineyepetizer.bean

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable


data class Banner(
        public val issueList: ArrayList<Issue>,
        val nextPageUrl: String,
        val nextPublishTime: Long,
        val newestIssueType: String,
        val dialog: Any
) : Serializable

data class Issue(
        val releaseTime: Long,
        val type: String,
        val date: Long,
        val publishTime: Long,
        val itemList: ArrayList<Item>,
        val count: Int
) : Serializable

data class Item(
        val type: String,
        val data: Data,
        val tag: Any,
        val id: Int,
        val adIndex: Int
) : Serializable

data class Data(
        val dataType: String,
        val id: Int,
        val title: String,
        val description: String,
        val library: String,
        val tags: ArrayList<Tag>,
        val consumption: Consumption,
        val resourceType: String,
        val slogan: String,
        val provider: Provider,
        val category: String,
        val author: Author,
        val cover: Cover,
        val playUrl: String,
        val thumbPlayUrl: Any,
        val duration: Int,
        val webUrl: WebUrl,
        val releaseTime: Long,
        val playInfo: ArrayList<PlayInfo>,
        val campaign: Any,
        val waterMarks: Any,
        val adTrack: Any,
        val type: String,
        val titlePgc: Any,
        val descriptionPgc: Any,
        val remark: Any,
        val ifLimitVideo: Boolean,
        val searchWeight: Int,
        val idx: Int,
        val shareAdTrack: Any,
        val favoriteAdTrack: Any,
        val webAdTrack: Any,
        val date: Long,
        val promotion: Any,
        val label: Any,
        val labelList: ArrayList<Any>,
        val descriptionEditor: String,
        val collected: Boolean,
        val played: Boolean,
        val subtitles: ArrayList<Any>,
        val lastViewTime: Any,
        val playlists: Any,
        val src: Any
) : Serializable

data class PlayInfo(
        val height: Int,
        val width: Int,
        val urlList: ArrayList<Url>,
        val name: String,
        val type: String,
        val url: String
) : Serializable

data class Url(
        val name: String,
        val url: String,
        val size: Int
) : Serializable

data class Tag(
        val id: Int,
        val name: String,
        val actionUrl: String,
        val adTrack: Any,
        val desc: Any,
        val bgPicture: String,
        val headerImage: String,
        val tagRecType: String
) : Serializable

data class Provider(
        val name: String,
        val alias: String,
        val icon: String
) : Serializable

data class Cover(
        val feed: String,
        val detail: String,
        val blurred: String,
        val sharing: Any,
        val homepage: String
) : Serializable

data class Consumption(
        val collectionCount: Int,
        val shareCount: Int,
        val replyCount: Int
) : Serializable

data class WebUrl(
        val raw: String,
        val forWeibo: String
) : Serializable

data class Author(
        val id: Int,
        val icon: String,
        val name: String,
        val description: String,
        val link: String,
        val latestReleaseTime: Long,
        val videoNum: Int,
        val adTrack: Any,
        val follow: Follow,
        val shield: Shield,
        val approvedNotReadyVideoCount: Int,
        val ifPgc: Boolean
) : Serializable

data class Shield(
        val itemType: String,
        val itemId: Int,
        val shielded: Boolean
) : Serializable

data class Follow(
        val itemType: String,
        val itemId: Int,
        val followed: Boolean
) : Serializable


