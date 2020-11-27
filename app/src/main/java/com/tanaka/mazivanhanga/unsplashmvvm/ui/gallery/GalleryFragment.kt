package com.tanaka.mazivanhanga.unsplashmvvm.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tanaka.mazivanhanga.unsplashmvvm.R
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Tanaka Mazivanhanga on 11/27/2020
 */
@AndroidEntryPoint
class GalleryFragment: Fragment(R.layout.fragment_gallery) {
    private val viewModel by viewModels<GalleryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.photos.observe(viewLifecycleOwner){

        }
    }
}