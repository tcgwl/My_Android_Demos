package com.archer.demos.dagger.module.a02activity;

import com.archer.demos.dagger.bean.Student;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Archer on 2018/4/17.
 */
@Module
public class A02Module {
    private A02Activity activity;

    public A02Module(A02Activity activity) {
        this.activity = activity;
    }

    @Provides
    Student provideStudent() {
        return new Student();
    }
}
