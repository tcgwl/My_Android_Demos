package com.archer.demos.dagger.module.a02activity.global;

import android.content.SharedPreferences;

import com.archer.demos.MyApp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Archer on 2018/4/17.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    SharedPreferences sharedPreferences();
    MyApp application();
}
