package com.archer.demos.dagger.module.a01activity;

import dagger.Component;

/**
 * Created by Archer on 2018/4/17.
 */
@Component(modules = A01SimpleModule.class)
public interface A01SimpleComponent {

    void inject(A01SimpleActivity activity);
}
