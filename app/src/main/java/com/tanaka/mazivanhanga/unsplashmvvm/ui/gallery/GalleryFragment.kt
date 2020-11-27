package com.tanaka.mazivanhanga.unsplashmvvm.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tanaka.mazivanhanga.unsplashmvvm.R
import com.tanaka.mazivanhanga.unsplashmvvm.databinding.FragmentGalleryBinding
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Tanaka Mazivanhanga on 11/27/2020
 */
@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {
    private val viewModel by viewModels<GalleryViewModel>()
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGalleryBinding.bind(view)
        val adapter = UnsplashPhotoAdapter()

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }
        viewModel.photos.observe(viewLifecycleOwner) {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}