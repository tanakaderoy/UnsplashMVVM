package com.tanaka.mazivanhanga.unsplashmvvm.di

import com.tanaka.mazivanhanga.unsplashmvvm.api.UnsplashApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by Tanaka Mazivanhanga on 11/27/2020
 */
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideClient():OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            })
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(UnsplashApi.BASE_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun provideUnsplashApi(retrofit: Retrofit): UnsplashApi =
        retrofit.create(UnsplashApi::class.java)

}
