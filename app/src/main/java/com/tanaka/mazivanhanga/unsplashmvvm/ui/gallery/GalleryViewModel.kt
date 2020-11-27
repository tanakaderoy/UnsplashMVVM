package com.tanaka.mazivanhanga.unsplashmvvm.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.tanaka.mazivanhanga.unsplashmvvm.models.UnsplashRepository


/**
 * Created by Tanaka Mazivanhanga on 11/27/2020
 */
class GalleryViewModel @ViewModelInject constructor(
    private val repository: UnsplashRepository
) :
    ViewModel() {
    private val currentQuery = MutableLiveData(DEFAULT_QUERY)
    val photos = currentQuery.switchMap { repository.getSearchResults(query = it).cachedIn(viewModelScope) }

    fun searchPhotos(query:String){
        currentQuery.value = query
    }

    companion object{
        private const val DEFAULT_QUERY = "soccer"
    }
}