package com.eldiar.pictureapp.domain.repository;

import com.eldiar.pictureapp.domain.models.Photo;

import java.util.List;

import io.reactivex.Observable;

public interface PhotoRepository {

    Observable<List<Photo>> getData();

}
