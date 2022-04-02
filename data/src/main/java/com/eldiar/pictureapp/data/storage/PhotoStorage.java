package com.eldiar.pictureapp.data.storage;


import com.eldiar.pictureapp.domain.models.Photo;

import java.util.List;

import io.reactivex.Observable;

public interface PhotoStorage {

    Observable<List<Photo>> getData();
}
