package com.yogify.study.ui.home.dataclass

import androidx.annotation.Keep

@Keep
data class BannerHomeScreenItem(
    val BannerUrl: String?=null,
    val CreatedBy: Int?=null,
    val CreatedOn: String?=null,
    val Id: Int?=null,
    val MobileDeeplinkUrl: String?=null,
    val WebsiteLink: String?=null,
    val menuCode: String?=null
)