package com.archer.demos.dagger.module.a02activity;

import com.archer.demos.dagger.module.a02activity.global.AppComponent;
import com.archer.demos.dagger.module.a03scope.scope.ActivityScope;

import dagger.Component;

/**
 * Created by Archer on 2018/4/17.
 */
@ActivityScope
@Component(modules = A02Module.class, dependencies = AppComponent.class)
public interface A02Component {

    void inject(A02Activity activity);
}
