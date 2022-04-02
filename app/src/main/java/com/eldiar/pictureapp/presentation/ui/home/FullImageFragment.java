package com.eldiar.pictureapp.presentation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.eldiar.pictureapp.R;
import com.eldiar.pictureapp.databinding.FragmentFullImageBinding;

public class FullImageFragment extends Fragment {

    private FragmentFullImageBinding binding;
    private static final String IMAGE_KEY = "imageUrl";

    private String imageUrl;

    public FullImageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageUrl = getArguments().getString(IMAGE_KEY);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFullImageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViews();
    }

    private void setupViews() {
        Glide.with(requireContext())
                .load(imageUrl)
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(binding.imageIv);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}