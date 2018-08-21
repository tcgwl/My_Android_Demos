package com.archer.demos.dagger.module.a03scope;

import android.widget.TextView;

import com.archer.demos.BaseActivity;
import com.archer.demos.R;
import com.archer.demos.dagger.bean.Student;

import javax.inject.Inject;

import butterknife.BindView;

public class A04Activity extends BaseActivity {
    @BindView(R.id.tv_student)
    TextView tvStudent;

    @Inject
    Student student;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_a04;
    }

    @Override
    protected void initEventAndData() {
        DaggerA04Component.builder()
                .a04Module(new A04Module(this))
                .build()
                .inject(this);

        //打印Student
        tvStudent.setText(student.toString());
    }
}
