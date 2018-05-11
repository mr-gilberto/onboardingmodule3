package com.globant.equattrocchio.cleanarchitecture.mvp.presenter;

import android.app.Activity;

import com.globant.equattrocchio.cleanarchitecture.util.bus.RxBus;
import com.globant.equattrocchio.cleanarchitecture.mvp.view.ImagesView;
import com.globant.equattrocchio.data.ImagesServicesImpl;
import com.globant.equattrocchio.data.response.ImageResponse;
import com.globant.equattrocchio.data.response.ResultResponse;
import com.globant.equattrocchio.domain.GetLatestImagesUseCase;
import com.globant.equattrocchio.domain.data.Image;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class ImagesPresenter {

    private ImagesView view;
    private GetLatestImagesUseCase getLatestImagesUseCase;

    public ImagesPresenter(ImagesView view, GetLatestImagesUseCase getLatestImagesUseCase) {
        this.view = view;
        this.getLatestImagesUseCase = getLatestImagesUseCase;
        init();
    }

    private void init() {
        callServiceImages();
    }


    private void callServiceImages() {

        getLatestImagesUseCase.execute(new DisposableObserver<List<Image>>() {

            @Override
            public void onNext(@NonNull List<Image> images) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                new ImagesServicesImpl().getLatestImages(new DisposableObserver<List<Image>>() {
                    @Override
                    public void onNext(List<Image> images) {
                        view.setItemsAdapter(images);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
            }
        }, null);

    }

    public void register() {
        Activity activity = view.getActivity();
        if (activity != null) {
        }
    }

    public void unregister() {
        Activity activity = view.getActivity();
        if (activity != null) {
            RxBus.clear(activity);
        }
    }
}
