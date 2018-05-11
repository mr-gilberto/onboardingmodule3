package com.globant.equattrocchio.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultResponse {
    @SerializedName("images")
    @Expose
    private List<ImageResponse> mImageResponses = null;

    public List<ImageResponse> getImages() {
        return mImageResponses;
    }

    public void setImages(List<ImageResponse> imageResponses) {
        this.mImageResponses = imageResponses;
    }

}