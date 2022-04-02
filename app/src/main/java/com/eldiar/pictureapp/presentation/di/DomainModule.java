package com.eldiar.pictureapp.presentation.di;

import com.eldiar.pictureapp.domain.repository.PhotoRepository;
import com.eldiar.pictureapp.domain.usecase.GetPicturesUseCase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;

@Module
@InstallIn(ViewModelComponent.class)
public class DomainModule {

    @Provides
    public GetPicturesUseCase provideGetPictureUseCase(PhotoRepository photoRepository) {
        return new GetPicturesUseCase(photoRepository);
    }
}
