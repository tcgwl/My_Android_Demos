package com.archer.demos.dagger.module.a02activity.global;

import android.content.Context;
import android.content.SharedPreferences;

import com.archer.demos.MyApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Archer on 2018/4/17.
 */
@Module
public class AppModule {
    private MyApp application;

    public AppModule(MyApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences() {
        return application.getSharedPreferences("spfile", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    public MyApp provideApplication() {
        return application;
    }
}
