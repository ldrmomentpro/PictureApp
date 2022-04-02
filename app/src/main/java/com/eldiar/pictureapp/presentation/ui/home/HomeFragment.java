package com.eldiar.pictureapp.presentation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.eldiar.pictureapp.databinding.FragmentHomeBinding;
import com.eldiar.pictureapp.domain.models.Photo;
import com.eldiar.pictureapp.presentation.ui.home.adapter.ImageListener;
import com.eldiar.pictureapp.presentation.ui.home.adapter.PhotoAdapter;
import com.eldiar.pictureapp.presentation.ui.home.viewmodel.HomeViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment implements ImageListener {

    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        viewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.photoRecycler.setHasFixedSize(true);
        binding.photoRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.loadData();

        viewModel.photos.observe(getViewLifecycleOwner(), this::displayData);
    }


    private void displayData(List<Photo> photoList) {
        PhotoAdapter adapter = new PhotoAdapter(requireContext(), photoList, this);
        binding.photoRecycler.setAdapter(adapter);
    }

    @Override
    public void doOnImageClick(Photo photo) {
        HomeFragmentDirections.ActionNavigationHomeToFullImageFragment action =
                HomeFragmentDirections.actionNavigationHomeToFullImageFragment();
        action.setImageUrl(photo.download_url);
        Navigation.findNavController(getView()).navigate(action);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}