package com.tanaka.mazivanhanga.unsplashmvvm.api

import com.tanaka.mazivanhanga.unsplashmvvm.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


/**
 * Created by Tanaka Mazivanhanga on 11/27/2020
 */
interface UnsplashApi {
    companion object{
        const val CLIENT_ID = BuildConfig.UNSPLASH_ACCESS_KEY
        const val BASE_URL = "https://api.unsplash.com/"
    }
    @Headers("Accept-Version:  v1","Authorization: client-ID $CLIENT_ID"
    )
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UnsplashResponse
}