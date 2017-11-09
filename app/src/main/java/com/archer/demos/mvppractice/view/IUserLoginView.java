package com.archer.demos.mvppractice.view;

import com.archer.demos.mvppractice.bean.User;

/**
 * 对于View的接口有哪些方法，可以从以下几点考虑:
 * 1.该操作需要什么, eg: getUserName, getPassword
 * 2.该操作的结果，对应的反馈, eg: toMainActivity, handleLoginFailed
 * 3.该操作过程中对应的友好交互, eg: showLoading, hideLoading
 */

public interface IUserLoginView {
    String getUserName();
    String getPassword();
    void showLoading();
    void hideLoading();
    void clearUserName();
    void clearPassword();
    void toMainActivity(User user);
    void handleLoginFailed(String reason);
    void hideInputMethodKeyBoard();
}
