package com.summer.kotlineyepetizer.bean

import com.google.gson.annotations.SerializedName



data class Guanzhu(
    @SerializedName("tabInfo") var tabInfo: TabInfo
) {

    data class TabInfo(
        @SerializedName("tabList") var tabList: ArrayList<Tab>,
        @SerializedName("defaultIdx") var defaultIdx: Int
    ) {

        data class Tab(
            @SerializedName("id") var id: Int,
            @SerializedName("name") var name: String,
            @SerializedName("apiUrl") var apiUrl: String
        )
    }
}