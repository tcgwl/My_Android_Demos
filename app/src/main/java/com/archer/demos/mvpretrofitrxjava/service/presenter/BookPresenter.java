package com.archer.demos.mvpretrofitrxjava.service.presenter;

import android.content.Context;
import android.content.Intent;

import com.archer.demos.mvpretrofitrxjava.service.entity.Book;
import com.archer.demos.mvpretrofitrxjava.service.manager.DataManager;
import com.archer.demos.mvpretrofitrxjava.service.view.BookView;
import com.archer.demos.mvpretrofitrxjava.service.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Archer on 2017/12/7.
 */

public class BookPresenter implements Presenter {
    private Context mContext;
    private DataManager mDataManager;
    private CompositeSubscription mCompositeSubscription;
    private BookView mBookView;
    private Book mBook;

    public BookPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {
        mDataManager = new DataManager(mContext);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
        if (view instanceof BookView) {
            mBookView = (BookView) view;
        }
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getSearchBooks(String name, String tag, int start, int count) {
        mCompositeSubscription.add(mDataManager.getSearchBooks(name, tag, start, count)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<Book>() {
                @Override
                public void onCompleted() {
                    if (mBook != null) {
                        mBookView.onSuccess(mBook);
                    }
                }

                @Override
                public void onError(Throwable e) {
                    e.printStackTrace();
                    mBookView.onFailure("请求失败：" + e.getMessage());
                }

                @Override
                public void onNext(Book book) {
                    mBook = book;
                }
            }));
    }
}
