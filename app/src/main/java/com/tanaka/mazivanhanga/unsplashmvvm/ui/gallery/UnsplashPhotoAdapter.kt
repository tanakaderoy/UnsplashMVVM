package com.tanaka.mazivanhanga.unsplashmvvm.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tanaka.mazivanhanga.unsplashmvvm.R
import com.tanaka.mazivanhanga.unsplashmvvm.databinding.ItemUnsplashPhotoBinding
import com.tanaka.mazivanhanga.unsplashmvvm.models.UnsplashPhoto


/**
 * Created by Tanaka Mazivanhanga on 11/27/2020
 */
class UnsplashPhotoAdapter :
    PagingDataAdapter<UnsplashPhoto, UnsplashPhotoAdapter.PhotoViewHolder>(diffCallback = PHOTO_COMPARATOR) {

    class PhotoViewHolder(private val binding: ItemUnsplashPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UnsplashPhoto?) {
            item?.let {
                binding.apply {
                    textViewUsername.text = item.user.username
                    Glide.with(itemView)
                        .load(item.urls.regular)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.ic_error)
                        .into(imageView)
                }
            }
        }

    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<UnsplashPhoto>() {
            override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(
                oldItem: UnsplashPhoto,
                newItem: UnsplashPhoto
            ): Boolean =
                oldItem == newItem


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            ItemUnsplashPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = getItem(position = position)
        holder.bind(item)
    }
}
