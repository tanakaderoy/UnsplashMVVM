package com.tanaka.mazivanhanga.unsplashmvvm.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.tanaka.mazivanhanga.unsplashmvvm.models.UnsplashRepository


/**
 * Created by Tanaka Mazivanhanga on 11/27/2020
 */
class GalleryViewModel @ViewModelInject constructor(
    private val repository: UnsplashRepository
) :
    ViewModel() {
}