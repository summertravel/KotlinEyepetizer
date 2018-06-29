package com.summer.kotlineyepetizer.bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MaybeULike(
        @SerializedName("itemList") var itemList: ArrayList<Item>,
        @SerializedName("count") var count: Int, // 11
        @SerializedName("total") var total: Int, // 0
        @SerializedName("nextPageUrl") var nextPageUrl: String, // http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=1&isTag=false
        @SerializedName("adExist") var adExist: Boolean // false
) : Serializable {

    data class Item(
            @SerializedName("type") var type: String, // followCard
            @SerializedName("data") var data: Data,
            @SerializedName("tag") var tag: Any, // null
            @SerializedName("id") var id: Int, // 108355
            @SerializedName("adIndex") var adIndex: Int // -1
    ) : Serializable {

        data class Data(
                @SerializedName("dataType") var dataType: String, // FollowCard
                @SerializedName("header") var header: Header,
                @SerializedName("content") var content: Content,
                @SerializedName("adTrack") var adTrack: Any // null
        ) : Serializable {

            data class Header(
                    @SerializedName("id") var id: Int, // 108355
                    @SerializedName("title") var title: String, // 武丰珍
                    @SerializedName("font") var font: Any, // null
                    @SerializedName("subTitle") var subTitle: Any, // null
                    @SerializedName("subTitleFont") var subTitleFont: Any, // null
                    @SerializedName("textAlign") var textAlign: String, // left
                    @SerializedName("cover") var cover: Any, // null
                    @SerializedName("label") var label: Any, // null
                    @SerializedName("actionUrl") var actionUrl: String, // eyepetizer://pgc/detail/3214/?title=%E6%AD%A6%E4%B8%B0%E7%8F%8D&userType=PGC&tabIndex=1
                    @SerializedName("labelList") var labelList: Any, // null
                    @SerializedName("icon") var icon: String, // http://img.kaiyanapp.com/5eb9baa6cb8d2591d821deeeb7af9194.png?imageMogr2/quality/60/format/jpg
                    @SerializedName("iconType") var iconType: String, // round
                    @SerializedName("description") var description: String, // #创意
                    @SerializedName("time") var time: Long, // 1528415378000
                    @SerializedName("showHateVideo") var showHateVideo: Boolean // false
            ) : Serializable


            data class Content(
                    @SerializedName("type") var type: String, // video
                    @SerializedName("data") var data: Data,
                    @SerializedName("tag") var tag: Any, // null
                    @SerializedName("id") var id: Int, // 0
                    @SerializedName("adIndex") var adIndex: Int // -1
            ) : Serializable {

                data class Data(
                        @SerializedName("dataType") var dataType: String, // VideoBeanForClient
                        @SerializedName("id") var id: Int, // 108355
                        @SerializedName("title") var title: String, // 沙画《葫芦兄弟》第十三集
                        @SerializedName("description") var description: String, // 大结局：七个葫芦娃团结一心，将妖精全部消灭。虽然我们采用的是原音原景，只是换了一种艺术表现手法，对沙画师来说也是一种极大的挑战。希望我们的沙画师能再接再厉，为大家呈现更美的作品。
                        @SerializedName("library") var library: String, // NOT_RECOMMEND
                        @SerializedName("tags") var tags: ArrayList<Tag>,
                        @SerializedName("consumption") var consumption: Consumption,
                        @SerializedName("resourceType") var resourceType: String, // video
                        @SerializedName("slogan") var slogan: Any, // null
                        @SerializedName("provider") var provider: Provider,
                        @SerializedName("category") var category: String, // 创意
                        @SerializedName("author") var author: Author,
                        @SerializedName("cover") var cover: Cover,
                        @SerializedName("playUrl") var playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=108355&resourceType=video&editionType=default&source=aliyun
                        @SerializedName("thumbPlayUrl") var thumbPlayUrl: Any, // null
                        @SerializedName("duration") var duration: Int, // 569
                        @SerializedName("webUrl") var webUrl: WebUrl,
                        @SerializedName("releaseTime") var releaseTime: Long, // 1528415378000
                        @SerializedName("playInfo") var playInfo: ArrayList<PlayInfo>,
                        @SerializedName("campaign") var campaign: Any, // null
                        @SerializedName("waterMarks") var waterMarks: Any, // null
                        @SerializedName("adTrack") var adTrack: Any, // null
                        @SerializedName("type") var type: String, // NORMAL
                        @SerializedName("titlePgc") var titlePgc: String, // 沙画《葫芦兄弟》第十三集
                        @SerializedName("descriptionPgc") var descriptionPgc: String, // 大结局：七个葫芦娃团结一心，将妖精全部消灭。虽然我们采用的是原音原景，只是换了一种艺术表现手法，对沙画师来说也是一种极大的挑战。希望我们的沙画师能再接再厉，为大家呈现更美的作品。
                        @SerializedName("remark") var remark: String,
                        @SerializedName("ifLimitVideo") var ifLimitVideo: Boolean, // false
                        @SerializedName("searchWeight") var searchWeight: Int, // 0
                        @SerializedName("idx") var idx: Int, // 0
                        @SerializedName("shareAdTrack") var shareAdTrack: Any, // null
                        @SerializedName("favoriteAdTrack") var favoriteAdTrack: Any, // null
                        @SerializedName("webAdTrack") var webAdTrack: Any, // null
                        @SerializedName("date") var date: Long, // 1528415378000
                        @SerializedName("promotion") var promotion: Any, // null
                        @SerializedName("label") var label: Any, // null
                        @SerializedName("labelList") var labelList: ArrayList<Any>,
                        @SerializedName("descriptionEditor") var descriptionEditor: String,
                        @SerializedName("collected") var collected: Boolean, // false
                        @SerializedName("played") var played: Boolean, // false
                        @SerializedName("subtitles") var subtitles: ArrayList<Any>,
                        @SerializedName("lastViewTime") var lastViewTime: Any, // null
                        @SerializedName("playlists") var playlists: Any, // null
                        @SerializedName("src") var src: Int // 4
                ) : Serializable {

                    data class PlayInfo(
                            @SerializedName("height") var height: Int, // 720
                            @SerializedName("width") var width: Int, // 1280
                            @SerializedName("urlList") var urlList: ArrayList<Url>,
                            @SerializedName("name") var name: String, // 高清
                            @SerializedName("type") var type: String, // high
                            @SerializedName("url") var url: String // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=108355&resourceType=video&editionType=high&source=aliyun
                    ) : Serializable {

                        data class Url(
                                @SerializedName("name") var name: String, // ucloud
                                @SerializedName("url") var url: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=108355&resourceType=video&editionType=high&source=ucloud
                                @SerializedName("size") var size: Int // 114422292
                        ) : Serializable
                    }


                    data class WebUrl(
                            @SerializedName("raw") var raw: String, // http://www.eyepetizer.net/detail.html?vid=108355
                            @SerializedName("forWeibo") var forWeibo: String // http://www.eyepetizer.net/detail.html?vid=108355
                    ) : Serializable


                    data class Cover(
                            @SerializedName("feed") var feed: String, // http://img.kaiyanapp.com/8578a9f81f9d4930542a125472eceb40.png?imageMogr2/quality/60/format/jpg
                            @SerializedName("detail") var detail: String, // http://img.kaiyanapp.com/8578a9f81f9d4930542a125472eceb40.png?imageMogr2/quality/60/format/jpg
                            @SerializedName("blurred") var blurred: String, // http://img.kaiyanapp.com/257a523997568c928b9443e8c00fd130.jpeg?imageMogr2/quality/60/format/jpg
                            @SerializedName("sharing") var sharing: Any, // null
                            @SerializedName("homepage") var homepage: Any // null
                    ) : Serializable


                    data class Author(
                            @SerializedName("id") var id: Int, // 3214
                            @SerializedName("icon") var icon: String, // http://img.kaiyanapp.com/5eb9baa6cb8d2591d821deeeb7af9194.png?imageMogr2/quality/60/format/jpg
                            @SerializedName("name") var name: String, // 武丰珍
                            @SerializedName("description") var description: String, // 沙画师 艺名：无邪 历年来创作了近五百部原创作品 连续两年举办金秋沙画嘉年华， 代表作：《美丽阳泉》系列7集 《葫芦兄弟》系列13集 《奥运专题》8集 其中部分作品被多家媒体采访报道。
                            @SerializedName("link") var link: String,
                            @SerializedName("latestReleaseTime") var latestReleaseTime: Long, // 1529512715000
                            @SerializedName("videoNum") var videoNum: Int, // 18
                            @SerializedName("adTrack") var adTrack: Any, // null
                            @SerializedName("follow") var follow: Follow,
                            @SerializedName("shield") var shield: Shield,
                            @SerializedName("approvedNotReadyVideoCount") var approvedNotReadyVideoCount: Int, // 0
                            @SerializedName("ifPgc") var ifPgc: Boolean // true
                    ) : Serializable {

                        data class Follow(
                                @SerializedName("itemType") var itemType: String, // author
                                @SerializedName("itemId") var itemId: Int, // 3214
                                @SerializedName("followed") var followed: Boolean // false
                        ) : Serializable


                        data class Shield(
                                @SerializedName("itemType") var itemType: String, // author
                                @SerializedName("itemId") var itemId: Int, // 3214
                                @SerializedName("shielded") var shielded: Boolean // false
                        ) : Serializable
                    }


//                    data class Tag(
//                            @SerializedName("id") var id: Int, // 2
//                            @SerializedName("name") var name: String, // 创意
//                            @SerializedName("actionUrl") var actionUrl: String, // eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F
//                            @SerializedName("adTrack") var adTrack: Any, // null
//                            @SerializedName("desc") var desc: String,
//                            @SerializedName("bgPicture") var bgPicture: String, // http://img.kaiyanapp.com/e6eee049dd13fe8ce0712a6f2648d7e2.jpeg?imageMogr2/quality/100
//                            @SerializedName("headerImage") var headerImage: String, // http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100
//                            @SerializedName("tagRecType") var tagRecType: String // NORMAL
//                    ) : Serializable


                    data class Provider(
                            @SerializedName("name") var name: String, // PGC
                            @SerializedName("alias") var alias: String, // PGC
                            @SerializedName("icon") var icon: String
                    ) : Serializable


                    data class Consumption(
                            @SerializedName("collectionCount") var collectionCount: Int, // 10
                            @SerializedName("shareCount") var shareCount: Int, // 6
                            @SerializedName("replyCount") var replyCount: Int // 0
                    ) : Serializable
                }
            }
        }
    }
}