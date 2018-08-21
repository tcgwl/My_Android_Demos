package com.archer.androiddagger2.di.module;

import android.app.Activity;

import com.archer.androiddagger2.di.component.SecondActivitySubcomponent;
import com.archer.androiddagger2.mvp.activity.SecondActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Archer on 2018/4/18.
 */
@Module(subcomponents = SecondActivitySubcomponent.class)
public abstract class SecondActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(SecondActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
        bindSecondAndroidInjectorFactory(SecondActivitySubcomponent.Builder builder);
}
