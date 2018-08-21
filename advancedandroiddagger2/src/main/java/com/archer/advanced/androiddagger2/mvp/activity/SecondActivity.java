package com.archer.advanced.androiddagger2.mvp.activity;

import android.widget.TextView;

import com.archer.advanced.androiddagger2.R;
import com.archer.advanced.androiddagger2.base.BaseActivity;
import com.archer.advanced.androiddagger2.bean.Student;

import javax.inject.Inject;

public class SecondActivity extends BaseActivity {
    @Inject
    String className;
    @Inject
    Student student;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void initEventAndData() {
        TextView tv = (TextView) findViewById(R.id.tv_content);
        tv.setText(className + "\n" + student.toString());
    }
}
