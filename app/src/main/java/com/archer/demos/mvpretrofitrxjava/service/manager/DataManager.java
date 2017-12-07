package com.archer.demos.mvpretrofitrxjava.service.manager;

import android.content.Context;

import com.archer.demos.mvpretrofitrxjava.service.RetrofitHelper;
import com.archer.demos.mvpretrofitrxjava.service.RetrofitService;
import com.archer.demos.mvpretrofitrxjava.service.entity.Book;

import rx.Observable;

/**
 * Created by Archer on 2017/12/7.
 */

public class DataManager {
    private RetrofitService mRetrofitService;

    public DataManager(Context context) {
        mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }

    public Observable<Book> getSearchBooks(String name, String tag, int start, int count) {
        return mRetrofitService.getSearchBooks(name, tag, start, count);
    }
}
