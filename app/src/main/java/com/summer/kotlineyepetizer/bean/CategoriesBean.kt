package com.summer.kotlineyepetizer.bean
import com.google.gson.annotations.SerializedName


data class CategoriesBean(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("alias") var alias: Any,
    @SerializedName("description") var description: String,
    @SerializedName("bgPicture") var bgPicture: String,
    @SerializedName("bgColor") var bgColor: String,
    @SerializedName("headerImage") var headerImage: String,
    @SerializedName("defaultAuthorId") var defaultAuthorId: Int
)