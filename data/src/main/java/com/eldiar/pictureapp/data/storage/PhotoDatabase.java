package com.eldiar.pictureapp.data.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.eldiar.pictureapp.data.storage.dao.PhotoDao;
import com.eldiar.pictureapp.data.storage.entity.PhotoEntity;

@Database(entities = {PhotoEntity.class}, version = 1, exportSchema = false)
public abstract class PhotoDatabase extends RoomDatabase {

    public abstract PhotoDao photoDao();
}
