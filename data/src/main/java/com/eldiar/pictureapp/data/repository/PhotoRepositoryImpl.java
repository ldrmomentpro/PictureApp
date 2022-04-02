package com.eldiar.pictureapp.data.repository;

import com.eldiar.pictureapp.data.network.PhotoApi;
import com.eldiar.pictureapp.data.storage.PhotoStorage;
import com.eldiar.pictureapp.domain.models.Photo;
import com.eldiar.pictureapp.domain.repository.PhotoRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class PhotoRepositoryImpl implements PhotoRepository {

    PhotoApi api;

    @Inject
    public PhotoRepositoryImpl(PhotoApi api) {
        this.api = api;
    }

    @Override
    public Observable<List<Photo>> getData() {
        return api.getPhotos();
    }
}
