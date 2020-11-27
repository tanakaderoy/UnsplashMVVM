package com.tanaka.mazivanhanga.unsplashmvvm.api

import com.tanaka.mazivanhanga.unsplashmvvm.models.UnsplashPhoto


/**
 * Created by Tanaka Mazivanhanga on 11/27/2020
 */
data class UnsplashResponse(
    val results: List<UnsplashPhoto>
)