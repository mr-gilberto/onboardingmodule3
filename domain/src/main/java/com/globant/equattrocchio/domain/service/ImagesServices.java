package com.globant.equattrocchio.domain.service;

import com.globant.equattrocchio.domain.data.Image;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public interface ImagesServices {

    void getLatestImages(DisposableObserver<List<Image>> observer);

    void getImageById(DisposableObserver<Image> observer, String id);

}
