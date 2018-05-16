package com.globant.equattrocchio.data.mapper;

import com.globant.equattrocchio.data.Realm.ImageRealm;
import com.globant.equattrocchio.data.response.ImageResponse;
import com.globant.equattrocchio.domain.data.Image;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static ImageRealm imageToRealmImage(Image image) {
        ImageRealm imageRealm = new ImageRealm();
        imageRealm.setUrl(image.getUrl());
        imageRealm.setId(image.getId());
        return imageRealm;
    }

    public static Image imageRealmToImage(ImageRealm imageRealm) {
        Image image = new Image();
        image.setUrl(imageRealm.getUrl());
        image.setId(imageRealm.getId());
        return image;
    }


    public static Image imageToDomainImage(ImageResponse image) {
        Image imageDomain = new Image();
        imageDomain.setUrl(image.getUrl());
        imageDomain.setId(image.getId());
        return imageDomain;
    }


    public static List<Image> listImageResponseToImage(List<ImageResponse> imagesResponse) {
        List<Image> images = new ArrayList<>();
        for (ImageResponse image : imagesResponse) {
            images.add(imageToDomainImage(image));
        }
        return images;
    }


}



