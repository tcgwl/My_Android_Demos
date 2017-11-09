package com.archer.demos.mvppractice.biz;

import com.archer.demos.mvppractice.bean.User;

/**
 * Created by Archer on 2017/11/7.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed(String reason);
}
