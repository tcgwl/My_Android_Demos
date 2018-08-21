package com.archer.demos.dagger.module.a03scope;

import com.archer.demos.dagger.module.a02activity.global.AppComponent;
import com.archer.demos.dagger.module.a03scope.scope.ActivityScope;

import dagger.Component;

/**
 * Created by Archer on 2018/4/17.
 */
@ActivityScope//添加注解实现局部单例
@Component(modules = A03Module.class, dependencies = AppComponent.class)
public interface A03Component {

    void inject(A03Activity activity);
}
