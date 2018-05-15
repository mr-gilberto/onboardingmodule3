package com.globant.equattrocchio.data.service.api;

import com.globant.equattrocchio.data.response.ImageResponse;
import com.globant.equattrocchio.data.response.ResultResponse;
import com.globant.equattrocchio.domain.data.Image;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SplashbaseApi {

    @GET("api/v1/images/latest")
    Call<ResultResponse> getImages();

    @GET("api/v1/images/{id}")
    Call<ImageResponse> getImageById(@Path("id") String imageId);

}
