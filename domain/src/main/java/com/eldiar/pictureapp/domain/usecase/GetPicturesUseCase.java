package com.eldiar.pictureapp.domain.usecase;

import com.eldiar.pictureapp.domain.models.Photo;
import com.eldiar.pictureapp.domain.repository.PhotoRepository;

import java.util.List;

import io.reactivex.Observable;

public class GetPicturesUseCase {

    PhotoRepository photoRepository;

    public GetPicturesUseCase(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Observable<List<Photo>> execute() {
        return photoRepository.getData();
    }
}
