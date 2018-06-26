package com.core.zlxd.zcore.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    public static <T> T getApi(String baseUrl, Class<T> api) {
        OkHttpClient client = OkHttpUtils.getOkHttpSingletonInstance();
        return new Retrofit.Builder().baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(api);
    }
}
