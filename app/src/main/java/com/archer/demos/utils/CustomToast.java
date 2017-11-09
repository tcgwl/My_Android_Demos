package com.archer.demos.utils;

import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Archer on 2017/11/9.
 */

public class CustomToast {

    // Toast
    private static Toast toast;

    private static boolean isCenterShow() {
        if("Xiaomi".equals(Build.MANUFACTURER)){//小米手机
            return false;
        } else if("Meizu".equals(Build.MANUFACTURER)){//魅族手机
            return false;
        } else {//其他手机
        }
        return true;
    }

    /**
     * 短时间显示Toast
     */
    public static void showShort(Context context, CharSequence message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        if (isCenterShow()) {
            toast.setGravity(Gravity.CENTER, 0, 0);
        }
        toast.setText(message);
        toast.show();
    }

    /**
     * 短时间显示Toast
     */
    public static void showShort(Context context, int message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        if (isCenterShow()) {
            toast.setGravity(Gravity.CENTER, 0, 0);
        }
        toast.setText(message);
        toast.show();
    }

    /**
     * 长时间显示Toast
     */
    public static void showLong(Context context, CharSequence message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        }
        if (isCenterShow()) {
            toast.setGravity(Gravity.CENTER, 0, 0);
        }
        toast.setText(message);
        toast.show();
    }

    /**
     * 长时间显示Toast
     */
    public static void showLong(Context context, int message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        }
        if (isCenterShow()) {
            toast.setGravity(Gravity.CENTER, 0, 0);
        }
        toast.setText(message);
        toast.show();
    }

    /**
     * 自定义显示Toast时间
     */
    public static void showToast(Context context, CharSequence message, int duration) {
        if (null == toast) {
            toast = Toast.makeText(context, message, duration);
        }
        if (isCenterShow()) {
            toast.setGravity(Gravity.CENTER, 0, 0);
        }
        toast.setText(message);
        toast.show();
    }

    /**
     * 自定义显示Toast时间
     */
    public static void showToast(Context context, int message, int duration) {
        if (null == toast) {
            toast = Toast.makeText(context, message, duration);
        }
        if (isCenterShow()) {
            toast.setGravity(Gravity.CENTER, 0, 0);
        }
        toast.setText(message);
        toast.show();
    }

    /** Hide the toast, if any. */
    public static void hideToast() {
        if (null != toast) {
            toast.cancel();
        }
    }

    /**
     * 在debug模式下才显示toast
     */
    public static void showDebugShort(Context context, CharSequence message) {
        if (MM.DebugMode){
            showShort(context, "debug信息：" + message);
        }
    }

}
