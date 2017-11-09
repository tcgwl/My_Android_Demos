package com.archer.demos.mvppractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.archer.demos.R;
import com.archer.demos.mvppractice.bean.User;
import com.archer.demos.mvppractice.presenter.UserLoginPresenter;
import com.archer.demos.mvppractice.view.IUserLoginView;
import com.archer.demos.utils.CustomToast;
import com.archer.demos.utils.UIUtils;

public class LoginActivity extends AppCompatActivity implements IUserLoginView {

    private EditText mUserNameEt, mPasswordEt;
    private Button mLoginBtn, mClearBtn;
    private ProgressBar mLoadingPb;
    private UserLoginPresenter mLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        initEvents();
    }

    private void initViews() {
        mUserNameEt = (EditText) findViewById(R.id.et_username);
        mPasswordEt = (EditText) findViewById(R.id.et_password);
        mLoginBtn = (Button) findViewById(R.id.bt_login);
        mClearBtn = (Button) findViewById(R.id.bt_clear);
        mLoadingPb = (ProgressBar) findViewById(R.id.pb_loading);
    }

    private void initEvents() {
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.login();
            }
        });
        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return mUserNameEt.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return mPasswordEt.getText().toString().trim();
    }

    @Override
    public void showLoading() {
        mLoadingPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoadingPb.setVisibility(View.GONE);
    }

    @Override
    public void clearUserName() {
        mUserNameEt.setText("");
    }

    @Override
    public void clearPassword() {
        mPasswordEt.setText("");
    }

    @Override
    public void toMainActivity(User user) {
        CustomToast.showShort(UIUtils.getContext(), "Go to MainActivity");
    }

    @Override
    public void handleLoginFailed(String reason) {
        String msg = TextUtils.isEmpty(reason) ? "login failed" : reason;
        CustomToast.showShort(UIUtils.getContext(), msg);
    }

    @Override
    public void hideInputMethodKeyBoard() {
        UIUtils.hideInputMethodKeyBoard(LoginActivity.this);
    }
}
