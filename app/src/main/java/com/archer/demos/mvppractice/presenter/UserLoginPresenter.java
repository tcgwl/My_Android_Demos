package com.archer.demos.mvppractice.presenter;

import android.os.Handler;
import android.text.TextUtils;

import com.archer.demos.mvppractice.bean.User;
import com.archer.demos.mvppractice.biz.OnLoginListener;
import com.archer.demos.mvppractice.biz.UserBiz;
import com.archer.demos.mvppractice.view.IUserLoginView;

/**
 * Created by Archer on 2017/11/7.
 */
public class UserLoginPresenter {
    private IUserLoginView mUserLoginView;
    private UserBiz mUserBiz;
    private Handler mHandler;

    public UserLoginPresenter(IUserLoginView loginView) {
        mUserLoginView = loginView;
        mUserBiz = new UserBiz();
        mHandler = new Handler();
    }

    public void login() {
        String tmpUserName = mUserLoginView.getUserName();
        String tmpPassword = mUserLoginView.getPassword();
        if (TextUtils.isEmpty(tmpUserName) ||
                TextUtils.isEmpty(tmpPassword)) {
            mUserLoginView.handleLoginFailed("username or password can not be empty");
            return;
        }
        mUserLoginView.hideInputMethodKeyBoard();

        mUserLoginView.showLoading();
        User loginUser = new User();
        loginUser.setUsername(tmpUserName);
        loginUser.setPassword(tmpPassword);

        mUserBiz.login(loginUser, new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //在UI线程中更新UI
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.hideLoading();
                        mUserLoginView.toMainActivity(user);
                    }
                });
            }

            @Override
            public void loginFailed(final String reason) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.hideLoading();
                        mUserLoginView.handleLoginFailed(reason);
                    }
                });
            }
        });
    }

    public void clear() {
        mUserLoginView.hideInputMethodKeyBoard();
        mUserLoginView.clearUserName();
        mUserLoginView.clearPassword();
    }
}
