package com.archer.advanced.androiddagger2.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.archer.advanced.androiddagger2.bean.Student;
import com.archer.advanced.androiddagger2.di.scope.ActivityScope;
import com.archer.advanced.androiddagger2.mvp.activity.MainActivity;
import com.archer.advanced.androiddagger2.mvp.model.MainModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Archer on 2018/4/18.
 */
@Module
public class MainActivityModule {
    @Provides
    String provideName() {
        return MainActivity.class.getName();
    }

    @Provides
    @ActivityScope
    Student provideStudent() {
        return new Student();
    }

    @Provides
    SharedPreferences provideSharedPreferences(MainActivity activity) {
        return activity.getSharedPreferences("def", Context.MODE_PRIVATE);
    }

    @Provides
    MainModel provideModel() {
        return new MainModel();
    }
}
