package com.eldiar.pictureapp.presentation.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eldiar.pictureapp.databinding.ItemPhotoBinding;
import com.eldiar.pictureapp.domain.models.Photo;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    Context context;
    List<Photo> photoList;
    ImageListener listener;

    public PhotoAdapter(Context context, List<Photo> photoList, ImageListener listener) {
        this.context = context;
        this.photoList = photoList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhotoBinding binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false);
        return new PhotoViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Photo currentItem = photoList.get(position);
        if (currentItem != null) {
            holder.bind(currentItem);
        }
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }
}
