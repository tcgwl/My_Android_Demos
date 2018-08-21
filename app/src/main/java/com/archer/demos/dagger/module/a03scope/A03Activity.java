package com.archer.demos.dagger.module.a03scope;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.archer.demos.BaseActivity;
import com.archer.demos.R;
import com.archer.demos.dagger.bean.Student;
import com.archer.demos.dagger.module.a02activity.global.ComponentHolder;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class A03Activity extends BaseActivity {
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_student1)
    TextView tvStudent1;
    @BindView(R.id.tv_student2)
    TextView tvStudent2;

    @Inject
    Student student1;
    @Inject
    Student student2;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_a03;
    }

    @Override
    protected void initEventAndData() {
        DaggerA03Component.builder()
                .appComponent(ComponentHolder.getAppComponent())
                .a03Module(new A03Module(this))
                .build()
                .inject(this);

        //打印两个Student类
        tvStudent1.setText(student1.toString());
        tvStudent2.setText(student2.toString());
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        startActivity(new Intent(this, A04Activity.class));
    }
}
