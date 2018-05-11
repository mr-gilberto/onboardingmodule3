package com.globant.equattrocchio.data;

import com.globant.equattrocchio.data.service.api.SplashbaseApi;
import com.globant.equattrocchio.domain.service.ImagesServices;

import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ImagesServicesImpl implements ImagesServices {

    private static final String URL= "http://splashbase.co/";

    @Override
    public void getLatestImages(final Observer<String> observer) {

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        SplashbaseApi api  = retrofit.create(SplashbaseApi.class);
        Call<String> call = api.getImages();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                observer.onNext(response.body().toString());
                observer.onComplete();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                observer.onError(t);
            }
        });
    }
}
