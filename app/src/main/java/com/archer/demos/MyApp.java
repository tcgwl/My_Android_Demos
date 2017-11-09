package com.archer.demos;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 * Created by Archer on 2017/11/9.
 */
public class MyApp extends Application {
    private static Context context;
    private static Thread mainThread;
    private static long mainThreadId;
    private static Looper mainThreadLooper;
    private static Handler handler;

    @Override
    public void onCreate() {
        context = getApplicationContext();
        mainThread = Thread.currentThread();
        mainThreadId = android.os.Process.myTid();
        mainThreadLooper = getMainLooper();
        handler = new Handler();
        super.onCreate();

    }

    public static Context getContext() {
        return context;
    }

    public static Thread getMainThread() {
        return mainThread;
    }

    public static long getMainThreadId() {
        return mainThreadId;
    }

    public static Looper getMainThreadLooper() {
        return mainThreadLooper;
    }

    public static Handler getHandler() {
        return handler;
    }
}
