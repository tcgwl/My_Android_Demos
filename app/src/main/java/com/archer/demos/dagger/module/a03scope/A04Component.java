package com.archer.demos.dagger.module.a03scope;

import dagger.Component;

/**
 * Created by Archer on 2018/4/17.
 */
@Component(modules = A04Module.class)
public interface A04Component {

    void inject(A04Activity activity);
}
