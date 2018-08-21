package com.archer.advanced.androiddagger2.di.component;

import com.archer.advanced.androiddagger2.base.BaseActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by Archer on 2018/4/18.
 */
@Subcomponent(modules = {
        AndroidInjectionModule.class
})
public interface BaseActivityComponent extends AndroidInjector<BaseActivity> {
    //每一个继承BaseActivity的Activity，都共享同一个SubComponent
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseActivity> {

    }
}
