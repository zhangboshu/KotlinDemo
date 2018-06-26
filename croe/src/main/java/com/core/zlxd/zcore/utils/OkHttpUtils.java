package com.core.zlxd.zcore.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.core.zlxd.zcore.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {

    private static OkHttpClient okHttpClient = null;
    private static final int DEFAULT_TIMEOUT = 30;
    private static Context mContext;

    public static OkHttpClient getOkHttpSingletonInstance() {
        if (okHttpClient == null) {
            synchronized (OkHttpClient.class) {
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient();
                    //设置合理的超时
                    OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder()
                            .readTimeout(3, TimeUnit.SECONDS)
                            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS) //设置连接超时 30秒
                            .writeTimeout(3, TimeUnit.MINUTES)
                            .addInterceptor(new LoggingInterceptor())//添加请求拦截
                            .retryOnConnectionFailure(true);

                    //如果不是在正式包，添加拦截 打印响应json
                    if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(
                                new HttpLoggingInterceptor.Logger() {
                                    @Override
                                    public void log(String message) {
                                        if (TextUtils.isEmpty(message)) return;
                                        String s = message.substring(0, 1);
                                        //如果收到响应是json才打印
                                        if ("{".equals(s) || "[".equals(s)) {
                                            Log.i("okHttp", "收到响应: " + message);
                                        }
                                    }
                                });
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                        httpBuilder.addInterceptor(logging);
                    }
                    okHttpClient = httpBuilder.build();
                }
            }
        }
        return okHttpClient;
    }

    public static class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (BuildConfig.DEBUG) {
                Log.i("okhttp", String.format("发送请求 %s on %s%n%s",
                        request.url(), chain.connection(), request.headers()));
            }
            return chain.proceed(request);
        }
    }

}
