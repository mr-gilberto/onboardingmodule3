package com.globant.equattrocchio.data;

import com.globant.equattrocchio.data.mapper.Mapper;
import com.globant.equattrocchio.data.response.ImageResponse;
import com.globant.equattrocchio.data.response.ResultResponse;
import com.globant.equattrocchio.data.service.api.SplashbaseApi;
import com.globant.equattrocchio.domain.data.Image;
import com.globant.equattrocchio.domain.service.ImagesServices;


import java.util.List;
import java.util.logging.Level;

import io.reactivex.observers.DisposableObserver;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ImagesServicesImpl implements ImagesServices {

    private static final String URL = "http://splashbase.co/";

    Retrofit retrofit;

    public Retrofit getDefaultConfig() {
        if (retrofit == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            httpClient.addInterceptor(logging);  // <-- this is the important line!

            retrofit = new Retrofit.Builder().
                    baseUrl(URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

    @Override
    public void getLatestImages(final DisposableObserver<List<Image>> observer) {
        Retrofit retrofit = getDefaultConfig();
        SplashbaseApi api = retrofit.create(SplashbaseApi.class);
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



    @Override
    public void getImageById(final DisposableObserver<Image> observer, String id) {
        Retrofit retrofit = getDefaultConfig();
        SplashbaseApi api = retrofit.create(SplashbaseApi.class);
        Call<ImageResponse> call = api.getImageById(id);

        call.enqueue(new Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                observer.onNext(Mapper.imageToDomainImage(response.body()));
                observer.onComplete();
            }

            @Override
            public void onFailure(Call<ImageResponse> call, Throwable t) {
                observer.onError(t);
            }
        });
    }

}
