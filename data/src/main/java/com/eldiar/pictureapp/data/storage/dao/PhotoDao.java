package com.eldiar.pictureapp.data.storage.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.eldiar.pictureapp.data.storage.entity.PhotoEntity;
import com.eldiar.pictureapp.domain.models.Photo;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface PhotoDao {
    @Query("SELECT * FROM photo_table")
    public Observable<List<PhotoEntity>> getAllPhotos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertPhotos(List<PhotoEntity> photos);

    @Query("DELETE FROM photo_table")
    public void deleteAllPhotos();
}
