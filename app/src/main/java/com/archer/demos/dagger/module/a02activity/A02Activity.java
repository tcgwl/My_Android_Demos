package com.archer.demos.dagger.module.a02activity;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.archer.demos.BaseActivity;
import com.archer.demos.R;
import com.archer.demos.dagger.bean.Student;
import com.archer.demos.dagger.module.a02activity.global.ComponentHolder;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class A02Activity extends BaseActivity {
    @Inject
    Student student;
    @Inject
    SharedPreferences sp;

    @BindView(R.id.a02activity_btn)
    Button btn;
    @BindView(R.id.a02activity_tv)
    TextView tv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_a02;
    }

    @Override
    protected void initEventAndData() {
        DaggerA02Component.builder()
                .appComponent(ComponentHolder.getAppComponent())
                .a02Module(new A02Module(this))
                .build()
                .inject(this);
    }

    @OnClick(R.id.a02activity_btn)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.a02activity_btn:
                String studentMsg = "注入完毕，student = " + student.toString();
                String spMsg = "注入完毕，sp = " + sp.toString();
                Log.i("tag", studentMsg);
                Log.i("tag", spMsg);
                tv.setText(studentMsg + "\n" + spMsg);
                break;
            default:
                break;
        }
    }
}
