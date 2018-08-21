package com.archer.advanced.androiddagger2.di.module;

import com.archer.advanced.androiddagger2.di.component.BaseActivityComponent;
import com.archer.advanced.androiddagger2.di.scope.ActivityScope;
import com.archer.advanced.androiddagger2.mvp.activity.MainActivity;
import com.archer.advanced.androiddagger2.mvp.activity.SecondActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Archer on 2018/4/18.
 */
@Module(subcomponents = BaseActivityComponent.class)
public abstract class AllActivitysModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = SecondActivityModule.class)
    abstract SecondActivity contributeSecondActivityInjector();
}
