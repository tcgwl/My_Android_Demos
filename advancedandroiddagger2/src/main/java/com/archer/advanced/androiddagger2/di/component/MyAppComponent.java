package com.archer.advanced.androiddagger2.di.component;

import com.archer.advanced.androiddagger2.base.MyApplication;
import com.archer.advanced.androiddagger2.di.module.AllActivitysModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Archer on 2018/4/18.
 */
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AllActivitysModule.class
})
public interface MyAppComponent {
    void inject(MyApplication application);
}
