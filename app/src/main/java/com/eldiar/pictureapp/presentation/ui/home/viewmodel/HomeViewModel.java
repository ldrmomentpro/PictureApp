package com.eldiar.pictureapp.presentation.ui.home.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eldiar.pictureapp.domain.models.Photo;
import com.eldiar.pictureapp.domain.usecase.GetPicturesUseCase;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    private GetPicturesUseCase getPicturesUseCase;

    @Inject
    public HomeViewModel(GetPicturesUseCase getPicturesUseCase) {
        this.getPicturesUseCase = getPicturesUseCase;
    }

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final MutableLiveData<List<Photo>> photoMutableLiveData = new MutableLiveData<>();
    public final LiveData<List<Photo>> photos = photoMutableLiveData;

    public void loadData() {
        compositeDisposable.add((getPicturesUseCase.execute())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Photo>>() {

                    @Override
                    public void accept(List<Photo> photoList) throws Exception {
                        photoMutableLiveData.setValue(photoList);
                    }
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}