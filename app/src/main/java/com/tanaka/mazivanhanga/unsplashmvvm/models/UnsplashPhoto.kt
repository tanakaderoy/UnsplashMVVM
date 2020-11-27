package com.tanaka.mazivanhanga.unsplashmvvm.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Created by Tanaka Mazivanhanga on 11/27/2020
 */

@Parcelize
data class UnsplashPhoto(
    val id: String,
    val description: String?,
    val urls: UnsplashPhotoUrls
) : Parcelable {
    @Parcelize
    data class UnsplashPhotoUrls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    ) : Parcelable

    @Parcelize
    data class UnsplashUser(
        val username: String,
        val name: String

    ) : Parcelable {
        val attributionUrl get() = "https://unsplash.com/${username}?utm_source=AndroidMVVM&utm_medium=referral"
    }


}



