package com.summer.kotlineyepetizer.bean
import com.google.gson.annotations.SerializedName



data class DynamicInfoCardBean(
    @SerializedName("itemList") var itemList: ArrayList<Item>,
    @SerializedName("count") var count: Int,
    @SerializedName("total") var total: Int,
    @SerializedName("nextPageUrl") var nextPageUrl: String,
    @SerializedName("adExist") var adExist: Boolean
) {

    data class Item(
        @SerializedName("type") var type: String,
        @SerializedName("data") var data: Data,
        @SerializedName("tag") var tag: Any,
        @SerializedName("id") var id: Int,
        @SerializedName("adIndex") var adIndex: Int
    ) {

        data class Data(
            @SerializedName("dataType") var dataType: String,
            @SerializedName("dynamicType") var dynamicType: String,
            @SerializedName("text") var text: String,
            @SerializedName("actionUrl") var actionUrl: String,
            @SerializedName("user") var user: User,
            @SerializedName("mergeNickName") var mergeNickName: Any,
            @SerializedName("mergeSubTitle") var mergeSubTitle: Any,
            @SerializedName("merge") var merge: Boolean,
            @SerializedName("createDate") var createDate: Long,
            @SerializedName("simpleVideo") var simpleVideo: SimpleVideo,
            @SerializedName("reply") var reply: Reply
        ) {

            data class Reply(
                @SerializedName("id") var id: Long,
                @SerializedName("videoId") var videoId: Int,
                @SerializedName("videoTitle") var videoTitle: String,
                @SerializedName("message") var message: String,
                @SerializedName("likeCount") var likeCount: Int,
                @SerializedName("showConversationButton") var showConversationButton: Boolean,
                @SerializedName("parentReplyId") var parentReplyId: Int,
                @SerializedName("rootReplyId") var rootReplyId: Long,
                @SerializedName("ifHotReply") var ifHotReply: Boolean,
                @SerializedName("liked") var liked: Boolean,
                @SerializedName("parentReply") var parentReply: Any,
                @SerializedName("user") var user: User
            ) {

                data class User(
                    @SerializedName("uid") var uid: Int,
                    @SerializedName("nickname") var nickname: String,
                    @SerializedName("avatar") var avatar: String,
                    @SerializedName("userType") var userType: String,
                    @SerializedName("ifPgc") var ifPgc: Boolean,
                    @SerializedName("description") var description: Any,
                    @SerializedName("area") var area: Any,
                    @SerializedName("gender") var gender: Any,
                    @SerializedName("registDate") var registDate: Long,
                    @SerializedName("releaseDate") var releaseDate: Any,
                    @SerializedName("cover") var cover: Any,
                    @SerializedName("actionUrl") var actionUrl: String,
                    @SerializedName("followed") var followed: Boolean,
                    @SerializedName("limitVideoOpen") var limitVideoOpen: Boolean,
                    @SerializedName("library") var library: String
                )
            }


            data class User(
                @SerializedName("uid") var uid: Int,
                @SerializedName("nickname") var nickname: String,
                @SerializedName("avatar") var avatar: String,
                @SerializedName("userType") var userType: String,
                @SerializedName("ifPgc") var ifPgc: Boolean,
                @SerializedName("description") var description: Any,
                @SerializedName("area") var area: Any,
                @SerializedName("gender") var gender: Any,
                @SerializedName("registDate") var registDate: Long,
                @SerializedName("releaseDate") var releaseDate: Any,
                @SerializedName("cover") var cover: Any,
                @SerializedName("actionUrl") var actionUrl: String,
                @SerializedName("followed") var followed: Boolean,
                @SerializedName("limitVideoOpen") var limitVideoOpen: Boolean,
                @SerializedName("library") var library: String
            )


            data class SimpleVideo(
                @SerializedName("id") var id: Int,
                @SerializedName("resourceType") var resourceType: String,
                @SerializedName("uid") var uid: Int,
                @SerializedName("title") var title: String,
                @SerializedName("description") var description: String,
                @SerializedName("cover") var cover: Cover,
                @SerializedName("category") var category: String,
                @SerializedName("playUrl") var playUrl: String,
                @SerializedName("duration") var duration: Int,
                @SerializedName("releaseTime") var releaseTime: Long,
                @SerializedName("consumption") var consumption: Any,
                @SerializedName("collected") var collected: Boolean,
                @SerializedName("actionUrl") var actionUrl: String,
                @SerializedName("onlineStatus") var onlineStatus: String
            ) {

                data class Cover(
                    @SerializedName("feed") var feed: String,
                    @SerializedName("detail") var detail: String,
                    @SerializedName("blurred") var blurred: String,
                    @SerializedName("sharing") var sharing: Any,
                    @SerializedName("homepage") var homepage: String
                )
            }
        }
    }
}