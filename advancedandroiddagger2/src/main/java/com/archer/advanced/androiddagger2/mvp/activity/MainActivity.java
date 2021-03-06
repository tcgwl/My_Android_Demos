package com.archer.advanced.androiddagger2.mvp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.archer.advanced.androiddagger2.R;
import com.archer.advanced.androiddagger2.base.BaseActivity;
import com.archer.advanced.androiddagger2.bean.Student;
import com.archer.advanced.androiddagger2.mvp.contract.MainContract;
import com.archer.advanced.androiddagger2.mvp.presenter.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    String className;
    @Inject
    Student student1;
    @Inject
    Student student2;
    @Inject
    SharedPreferences sp;
    @Inject
    MainPresenter presenter;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        tvContent.setText(className + "\n" +
                student1.toString() + "\n" +
                student2.toString() + "\n" +
                sp.toString() + "\n" +
                presenter.toString());
    }

    public void gotoSecond(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void requestHttp(View view) {
        presenter.requestHttp();
    }

    public void onGetMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
