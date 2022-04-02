package com.eldiar.pictureapp.presentation.di;

import static com.eldiar.pictureapp.data.network.PhotoApi.BASE_URL;

import android.app.Application;

import androidx.room.Room;

import com.eldiar.pictureapp.data.network.PhotoApi;
import com.eldiar.pictureapp.data.repository.PhotoRepositoryImpl;
import com.eldiar.pictureapp.data.storage.PhotoDatabase;
import com.eldiar.pictureapp.data.storage.PhotoStorage;
import com.eldiar.pictureapp.domain.repository.PhotoRepository;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class DataModule {

    @Provides
    @Singleton
    public PhotoRepository providePhotoRepository(PhotoApi photoApi) {
        return new PhotoRepositoryImpl(photoApi);
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public PhotoApi providePhotoApi(Retrofit retrofit) {
        return retrofit.create(PhotoApi.class);
    }

    @Provides
    @Singleton
    public PhotoDatabase provideDatabase(Application app) {
        return Room.databaseBuilder(app, PhotoDatabase.class, "photo_database").build();
    }
}
