package com.archer.demos.dagger.module.a01activity;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.archer.demos.BaseActivity;
import com.archer.demos.R;
import com.archer.demos.dagger.bean.Student;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class A01SimpleActivity extends BaseActivity {
    private static final long DELAY_PERIOD = 4000;
    private static final long COUNT_DOWN_INTERVAL = 1000;

    @BindView(R.id.btn_01)
    Button btn01;
    @BindView(R.id.btn_02)
    Button btn02;
    @BindView(R.id.tv_03)
    TextView tv03;

    @Inject
    Student student;
    private CountDownTimer mCountDownTimer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_a01_simple;
    }

    @Override
    protected void initEventAndData() {
        DaggerA01SimpleComponent.builder()
                .a01SimpleModule(new A01SimpleModule(this))
                .build()
                .inject(this);

        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;
        Log.e("myTest", "xdpi="+xdpi+", ydpi="+ydpi);

        tv03.setText("确定下载");
        mCountDownTimer = new CountDownTimer(DELAY_PERIOD, COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv03.setText("确定下载[" + millisUntilFinished / 1000 + "s]");
            }

            @Override
            public void onFinish() {
                tv03.setText("确定下载");
            }
        };
    }

    @OnClick({R.id.btn_01, R.id.btn_02})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn_01:
                Toast.makeText(this, student.toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_02:
                mCountDownTimer.start();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            mCountDownTimer = null;
        }
        super.onDestroy();
    }
}
