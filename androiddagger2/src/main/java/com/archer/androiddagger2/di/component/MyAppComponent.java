package com.archer.androiddagger2.di.component;

import com.archer.androiddagger2.base.MyApplication;
import com.archer.androiddagger2.di.module.MainActivityModule;
import com.archer.androiddagger2.di.module.SecondActivityModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Archer on 2018/4/18.
 */
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        MainActivityModule.class,
        SecondActivityModule.class
})
public interface MyAppComponent {
    void inject(MyApplication application);
}
