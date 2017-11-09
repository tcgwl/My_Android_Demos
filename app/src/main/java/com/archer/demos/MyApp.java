package com.archer.demos;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;

import com.archer.demos.greendao.bean.DaoMaster;
import com.archer.demos.greendao.bean.DaoSession;

/**
 * Created by Archer on 2017/11/9.
 */
public class MyApp extends Application {
    private static Context context;
    private static Thread mainThread;
    private static long mainThreadId;
    private static Looper mainThreadLooper;
    private static Handler handler;

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        context = getApplicationContext();
        mainThread = Thread.currentThread();
        mainThreadId = android.os.Process.myTid();
        mainThreadLooper = getMainLooper();
        handler = new Handler();
        super.onCreate();

        initGreenDao();
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

    /**
     * 配置数据库
     */
    private void initGreenDao() {
        //创建数据库
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shop.db", null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }
}
