package com.archer.demos.mvpretrofitrxjava.service;

import android.content.Context;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Archer on 2017/12/7.
 */

public class RetrofitHelper {
    private Context mContext;
    private static RetrofitHelper mInstance = null;
    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient = new OkHttpClient();
    private GsonConverterFactory mGsonConverterFactory = GsonConverterFactory.create(new GsonBuilder().create());

    private RetrofitHelper(Context context) {
        mContext = context;
        init();
    }

    public static RetrofitHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (RetrofitHelper.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitHelper(context);
                }
            }
        }

        return mInstance;
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .client(mOkHttpClient)
                .addConverterFactory(mGsonConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public RetrofitService getServer() {
        return mRetrofit.create(RetrofitService.class);
    }
}
