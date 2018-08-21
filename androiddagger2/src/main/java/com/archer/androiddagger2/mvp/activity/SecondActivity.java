package com.archer.androiddagger2.mvp.activity;

import android.widget.TextView;

import com.archer.androiddagger2.R;
import com.archer.androiddagger2.base.BaseActivity;

import javax.inject.Inject;

public class SecondActivity extends BaseActivity {
    @Inject
    String className;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void initEventAndData() {
        TextView tv = (TextView) findViewById(R.id.tv_content);
        tv.setText(className);
    }
}
