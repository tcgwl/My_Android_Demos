package com.archer.demos.mvppractice.biz;

import com.archer.demos.mvppractice.bean.User;

/**
 * Created by Archer on 2017/11/7.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final User user, final OnLoginListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //模拟子线程耗时操作
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("archer".equals(user.getUsername()) && "123456".equals(user.getPassword())) {
                    if (listener != null) {
                        listener.loginSuccess(user);
                    }
                } else {
                    if (listener != null) {
                        listener.loginFailed("userName or password error");
                    }
                }
            }
        }).start();
    }
}
