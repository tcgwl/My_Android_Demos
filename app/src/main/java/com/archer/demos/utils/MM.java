package com.archer.demos.utils;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Archer on 2017/11/9.
 */

public class MM {
    // true为打开log
    public static boolean DebugMode = true;
    public static String mYtAG = "MM";

    private MM() {
    }

    public static void debugAsset(Object valid) {
        if (DebugMode) {
            debugAsset(valid != null);
        }
    }

    public static void debugAsset(Boolean valid) {
        if (DebugMode) {
            if (!valid) {
                final StackTraceElement[] stack = new Throwable().getStackTrace();
                for (int i = 0; i < stack.length; i++) {
                    final StackTraceElement ste = stack[i];
                    String classNameString = ste.getClassName();
                    classNameString = classNameString.substring(classNameString.lastIndexOf(".") + 1,
                            classNameString.length());
                    android.util.Log.v(mYtAG, "[" + classNameString + "." + ste.getMethodName() + "line:"
                            + ste.getLineNumber() + "] >>	" + "出问题啦!!!!!");
                }
                // try {
                //				String string = null;
                //				string.charAt(0);
                // } catch (Exception e) {
                // }
            }
        }
    }

    public static String stackTrace() {

        String string = "";
        final StackTraceElement[] stack = new Throwable().getStackTrace();
        for (int i = 0; i < stack.length; i++) {
            final StackTraceElement ste = stack[i];
            String classNameString = ste.getClassName();
            classNameString = classNameString.substring(classNameString.lastIndexOf(".") + 1,
                    classNameString.length());
            string += "[" + classNameString + "." + ste.getMethodName() + " line:"
                    + ste.getLineNumber() + "]\n";
        }

        return string;
    }

    public static void saveStackTraceToPath(String path) {
        File f = new File(path);
        f.deleteOnExit();
        File pathFile = f.getParentFile();
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            bw.write(MM.stackTrace());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 以“MM”为Tag，同时输出本语句被调用的位置
     *
     * @param string
     */
    public static void sysout(String string) {
        if (!DebugMode) {
            return;
        }
        final StackTraceElement[] stack = new Throwable().getStackTrace();
        final StackTraceElement ste = stack[1];
        String classNameString = ste.getClassName();
        classNameString = classNameString.substring(classNameString.lastIndexOf(".") + 1, classNameString.length());

        android.util.Log.v(mYtAG,
                "[" + classNameString + "." + ste.getMethodName() + " line:" + ste.getLineNumber() + "] >>	" + string);
    }

    public static void HKLog(String string) {
        sysout("hklog", string);
    }

    /**
     * 自定义Tag，同时输出本语句被调用的位置
     *
     * @param tag
     * @param string
     */
    public static void sysout(String tag, String string) {
        if (!DebugMode) {
            return;
        }
        final StackTraceElement[] stack = new Throwable().getStackTrace();
        final StackTraceElement ste = stack[1];
        String classNameString = ste.getClassName();
        classNameString = classNameString.substring(classNameString.lastIndexOf(".") + 1, classNameString.length());

        android.util.Log.v(tag,
                "[" + classNameString + "." + ste.getMethodName() + " line:" + ste.getLineNumber() + "] >>	" + string);
    }

    public static void sysoutHighlighted(String tag, String string) {
        if (!DebugMode) {
            return;
        }
        final StackTraceElement[] stack = new Throwable().getStackTrace();
        final StackTraceElement ste = stack[1];
        String classNameString = ste.getClassName();
        classNameString = classNameString.substring(classNameString.lastIndexOf(".") + 1, classNameString.length());

        android.util.Log.e(tag,
                "[" + classNameString + "." + ste.getMethodName() + " line:" + ste.getLineNumber() + "] >>	" + string);
    }

    /**
     * 打印所有的堆栈信息，同时输出本语句被调用的位置
     *
     * @param string
     */
    public static void sysoutAll(String string) {
        if (!DebugMode) {
            return;
        }
        final StackTraceElement[] stack = new Throwable().getStackTrace();
        android.util.Log.v(mYtAG, "  --------------------------------------------------------------------  ");
        for (int i = 0; i < stack.length; i++) {
            final StackTraceElement ste = stack[i];
            String classNameString = ste.getClassName();
            classNameString = classNameString.substring(classNameString.lastIndexOf(".") + 1, classNameString.length());

            android.util.Log.v(mYtAG, "[" + classNameString + "." + ste.getMethodName() + " line:" + ste.getLineNumber()
                    + "] >>	" + string);
        }
    }

    /**
     * 打印e中的堆栈消息
     *
     * @param e
     *            异常
     */
    public static void sysoutException(Exception e) {
        final StackTraceElement[] stack = e.getStackTrace();
        for (StackTraceElement ste : stack) {
            String classNameString = ste.getClassName();
            classNameString = classNameString.substring(classNameString.lastIndexOf(".") + 1, classNameString.length());
            android.util.Log.v("Exception", "[" + classNameString + "." + ste.getMethodName() + " line:"
                    + ste.getLineNumber() + "] >>	" + "assertout!!!!!");
        }
    }

    /**
     * 同时输出被调用的函数被调用的位置
     *
     * @param string
     */
    public static void whosysout(String string) {
        if (!DebugMode) {
            return;
        }
        final StackTraceElement[] stack = new Throwable().getStackTrace();
        final StackTraceElement ste = stack[2];
        String classNameString = ste.getClassName();
        classNameString = classNameString.substring(classNameString.lastIndexOf(".") + 1, classNameString.length());
        android.util.Log.v(mYtAG,
                "[" + classNameString + "." + ste.getMethodName() + " line:" + ste.getLineNumber() + "] >>	" + string);
    }

    /**
     * 同时输出被N级调用的位置 stage 取值 [1, N]
     *
     * @param string
     */
    public static void whosysout(String string, int stage) {
        if (!DebugMode) {
            return;
        }
        final StackTraceElement[] stack = new Throwable().getStackTrace();
        final StackTraceElement ste = stack[stage];
        String classNameString = ste.getClassName();
        classNameString = classNameString.substring(classNameString.lastIndexOf(".") + 1, classNameString.length());
        android.util.Log.v(mYtAG,
                "[" + classNameString + "." + ste.getMethodName() + " line:" + ste.getLineNumber() + "] >>	" + string);
    }

    /**
     * 输出本语句被调用的时间
     *
     * @param string
     */
    public static void sysTime(String string) {
        if (!DebugMode) {
            return;
        }
        long currentTime = System.currentTimeMillis();
        Log.v(mYtAG, string + "			" + (currentTime));

    }

    private static long time = 0;

    /**
     * 当前步骤执行的时间
     *
     * @param steps
     */
    public static void stepTime(String steps) {
        if (!DebugMode) {
            return;
        }
        long currentTime = System.currentTimeMillis();
        sysout("stepTime", steps + " :		" + (currentTime - time));
        time = currentTime;
    }

}
