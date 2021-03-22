package com.example.drawlayout_customview.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProduct {
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …
// add logging as last interceptor
            httpClient.addInterceptor(logging);  // <-- this is the important line!
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://210.245.87.82:8585")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

}
