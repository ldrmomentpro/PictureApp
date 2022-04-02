package com.eldiar.pictureapp.data.network;


import com.eldiar.pictureapp.domain.models.Photo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PhotoApi {
    String BASE_URL = "https://picsum.photos/";

    @GET("v2/list")
    Observable<List<Photo>> getPhotos();
}
