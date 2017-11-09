package com.archer.demos.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.archer.demos.MyApp;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by Archer on 2017/11/9.
 */

public class UIUtils {
    /**得到上下文*/
    public static Context getContext() {
        return MyApp.getContext();
    }

    /**得到Resouce对象*/
    public static Resources getResource() {
        return getContext().getResources();
    }

    /**得到String.xml中的字符串*/
    public static String getString(int resId) {
        return getResource().getString(resId);
    }

    /**得到String.xml中的字符串数组*/
    public static String[] getStringArr(int resId) {
        return getResource().getStringArray(resId);
    }

    /**得到colors.xml中的颜色*/
    public static int getColor(int colorId) {
        return getResource().getColor(colorId);
    }

    /**得到应用程序的包名*/
    public static String getPackageName() {
        return getContext().getPackageName();
    }

    /**得到主线程id*/
    public static long getMainThreadId() {
        return MyApp.getMainThreadId();
    }

    /**得到主线程Handler*/
    public static Handler getMainThreadHandler() {
        return MyApp.getHandler();
    }

    /**安全的执行一个任务*/
    public static void postTaskSafely(Runnable task) {
        int curThreadId = android.os.Process.myTid();

        if (curThreadId == getMainThreadId()) { // 如果当前线程是主线程
            task.run();
        } else { // 如果当前线程不是主线程
            getMainThreadHandler().post(task);
        }
    }

    /**
     * 隐藏输入法键盘
     */
    public static void hideInputMethodKeyBoard(Activity activity) {
        final View v = activity.getWindow().peekDecorView();
        if (v != null && v.getWindowToken() != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
}
