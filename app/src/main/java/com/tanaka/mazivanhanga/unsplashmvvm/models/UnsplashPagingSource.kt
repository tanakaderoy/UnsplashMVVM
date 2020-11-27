package com.tanaka.mazivanhanga.unsplashmvvm.models

import androidx.paging.PagingSource
import com.tanaka.mazivanhanga.unsplashmvvm.api.UnsplashApi
import retrofit2.HttpException
import java.io.IOException


/**
 * Created by Tanaka Mazivanhanga on 11/27/2020
 */

private const val UNSPLASH_START_PAGE_INDEX = 1

class UnsplashPagingSource(
    private val unsplashApi: UnsplashApi,
    private val query: String
) : PagingSource<Int, UnsplashPhoto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        val position = params.key ?: UNSPLASH_START_PAGE_INDEX
        return try {
            val response =
                unsplashApi.searchPhotos(query = query, page = position, perPage = params.loadSize)
            val photos = response.results
            LoadResult.Page(
                data = photos,
                prevKey = if (position == UNSPLASH_START_PAGE_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }

    }
}