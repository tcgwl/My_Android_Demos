package com.archer.androiddagger2.di.component;

import com.archer.androiddagger2.mvp.activity.SecondActivity;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by Archer on 2018/4/18.
 */
@Subcomponent(modules = {
        AndroidInjectionModule.class,
        SecondActivitySubcomponent.SubModule.class
})
public interface SecondActivitySubcomponent extends AndroidInjector<SecondActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SecondActivity> {

    }

    @Module
    class SubModule {
        @Provides
        String provideName() {
            return SecondActivity.class.getName();
        }
    }
}
