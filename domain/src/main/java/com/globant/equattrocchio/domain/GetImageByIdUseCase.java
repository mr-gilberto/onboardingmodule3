package com.globant.equattrocchio.domain;

import com.globant.equattrocchio.domain.data.Image;
import com.globant.equattrocchio.domain.service.ImagesServices;

import io.reactivex.observers.DisposableObserver;

public class GetImageByIdUseCase extends UseCase<Image,String> {

    private ImagesServices imagesServices;

    public GetImageByIdUseCase(ImagesServices imagesServices) {
        super();
        this.imagesServices = imagesServices;
    }

    @Override
    void buildUseCaseObservable(DisposableObserver<Image> observer, String imageId) {
        imagesServices.getImageById(observer, imageId);
    }
}
