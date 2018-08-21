package com.archer.demos.dagger.module.a03scope;

import com.archer.demos.dagger.bean.Student;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Archer on 2018/4/17.
 */
@Module
public class A04Module {
    private A04Activity activity;

    public A04Module(A04Activity activity) {
        this.activity = activity;
    }

    @Provides
    public Student provideStudent() {
        return new Student();
    }

}
