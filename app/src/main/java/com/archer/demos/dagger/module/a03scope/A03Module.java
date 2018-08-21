package com.archer.demos.dagger.module.a03scope;

import com.archer.demos.dagger.bean.Student;
import com.archer.demos.dagger.module.a03scope.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Archer on 2018/4/17.
 */
@Module
public class A03Module {
    private A03Activity activity;

    public A03Module(A03Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope//添加注解实现局部单例
    public Student provideStudent() {
        return new Student();
    }

}
