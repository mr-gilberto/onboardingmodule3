package com.globant.equattrocchio.data.mapper;

import com.globant.equattrocchio.data.response.ImageResponse;
import com.globant.equattrocchio.domain.data.Image;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

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



