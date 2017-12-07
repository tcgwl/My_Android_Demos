package com.archer.demos.mvpretrofitrxjava.service;

import com.archer.demos.mvpretrofitrxjava.service.entity.Book;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Archer on 2017/12/7.
 */

public interface RetrofitService {
    @GET("book/search")
    Observable<Book> getSearchBooks(@Query("q") String name, @Query("tag") String tag, @Query("start") int start, @Query("count") int count);
}
