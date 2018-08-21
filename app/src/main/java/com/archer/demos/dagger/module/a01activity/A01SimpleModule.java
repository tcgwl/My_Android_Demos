package com.archer.demos.dagger.module.a01activity;

import com.archer.demos.dagger.bean.Student;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Archer on 2018/4/17.
 */
@Module
public class A01SimpleModule {
    private A01SimpleActivity activity;

    public A01SimpleModule(A01SimpleActivity activity) {
        this.activity = activity;
    }

    @Provides
    public Student provideStudent() {
        return new Student();
    }
}
