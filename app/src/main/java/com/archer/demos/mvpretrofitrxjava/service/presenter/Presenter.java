package com.archer.demos.mvpretrofitrxjava.service.presenter;

import android.content.Intent;

import com.archer.demos.mvpretrofitrxjava.service.view.View;

/**
 * Created by Archer on 2017/12/7.
 */

public interface Presenter {
    void onCreate();
    void onStart();
    void onStop();
    void pause();
    void attachView(View view);
    void attachIncomingIntent(Intent intent);
}
