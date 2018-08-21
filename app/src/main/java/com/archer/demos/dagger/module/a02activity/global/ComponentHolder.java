package com.archer.demos.dagger.module.a02activity.global;

/**
 * Created by Archer on 2018/4/17.
 */

public class ComponentHolder {
    private static AppComponent sAppComponent;

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    public static void setAppComponent(AppComponent appComponent) {
        sAppComponent = appComponent;
    }
}
