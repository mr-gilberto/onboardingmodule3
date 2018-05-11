package com.globant.equattrocchio.data;

import com.globant.equattrocchio.data.mapper.Mapper;
import com.globant.equattrocchio.data.response.ImageResponse;
import com.globant.equattrocchio.data.response.ResultResponse;
import com.globant.equattrocchio.data.service.api.SplashbaseApi;
import com.globant.equattrocchio.domain.data.Image;
import com.globant.equattrocchio.domain.service.ImagesServices;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.observers.DisposableObserver;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ImagesServicesImpl implements ImagesServices {

    private static final String URL= "http://splashbase.co/";

    @Override
    public void getLatestImages(final DisposableObserver<List<Image>> observer) {

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SplashbaseApi api  = retrofit.create(SplashbaseApi.class);
        Call<ResultResponse> call = api.getImages();

        call.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                observer.onNext(Mapper.listImageResponseToImage(response.body().getImages()));
                observer.onComplete();
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                observer.onError(t);
            }
        });
    }
}
