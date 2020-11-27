package com.tanaka.mazivanhanga.unsplashmvvm.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tanaka.mazivanhanga.unsplashmvvm.databinding.UnsplashPhotoLoadStateFooterBinding


/**
 * Created by Tanaka Mazivanhanga on 11/27/2020
 */
class UnsplashPhotoLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<UnsplashPhotoLoadStateAdapter.LoadStateVieHolder>() {
    override fun onBindViewHolder(holder: LoadStateVieHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateVieHolder {
        val binding = UnsplashPhotoLoadStateFooterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return LoadStateVieHolder(binding)

    }

    inner class LoadStateVieHolder(private val binding: UnsplashPhotoLoadStateFooterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                buttonRetry.setOnClickListener {
                    retry.invoke()
                }
            }
        }

        fun bind(loadState: LoadState) {
            binding.apply {
                progressBar.isVisible = loadState is LoadState.Loading
                buttonRetry.isVisible = loadState !is LoadState.Loading
                textViewError.isVisible = loadState !is LoadState.Loading

            }
        }

    }

}