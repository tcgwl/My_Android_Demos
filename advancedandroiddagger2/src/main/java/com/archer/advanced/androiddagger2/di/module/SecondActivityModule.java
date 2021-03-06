package com.archer.advanced.androiddagger2.di.module;

import com.archer.advanced.androiddagger2.bean.Student;
import com.archer.advanced.androiddagger2.di.scope.ActivityScope;
import com.archer.advanced.androiddagger2.mvp.activity.SecondActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Archer on 2018/4/18.
 */
@Module
public class SecondActivityModule {
    @Provides
    String provideName() {
        return SecondActivity.class.getName();
    }
    @Provides
    @ActivityScope
    Student provideStudent() {
        return new Student();
    }
}
