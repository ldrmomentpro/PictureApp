package com.eldiar.pictureapp.presentation.ui.home.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eldiar.pictureapp.R;
import com.eldiar.pictureapp.databinding.ItemPhotoBinding;
import com.eldiar.pictureapp.domain.models.Photo;

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    private final ItemPhotoBinding binding;
    private final ImageListener listener;

    public PhotoViewHolder(ItemPhotoBinding binding, ImageListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    public void bind(Photo photo) {
        Glide.with(itemView)
                .load(photo.download_url)
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(binding.photoIv);
        binding.photoIv.setOnClickListener(view -> listener.doOnImageClick(photo));
        binding.authorTv.setText(binding.getRoot().getContext().getString(R.string.author, photo.author));
    }
}
