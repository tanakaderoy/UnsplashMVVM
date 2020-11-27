package com.tanaka.mazivanhanga.unsplashmvvm.models

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.tanaka.mazivanhanga.unsplashmvvm.api.UnsplashApi
import javax.inject.Inject


/**
 * Created by Tanaka Mazivanhanga on 11/27/2020
 */
class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {
    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20, maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                UnsplashPagingSource(unsplashApi, query = query)
            }
        ).liveData
}