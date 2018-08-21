package com.archer.demos.dagger;

import android.content.Intent;
import android.view.View;

import com.archer.demos.BaseActivity;
import com.archer.demos.R;
import com.archer.demos.dagger.module.a01activity.A01SimpleActivity;
import com.archer.demos.dagger.module.a02activity.A02Activity;
import com.archer.demos.dagger.module.a03scope.A03Activity;

import butterknife.OnClick;

/**
 * Created by Archer on 2018/4/17.
 */

public class DaggerSampleActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_dagger_sample;
    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick({R.id.dagger_btn_01, R.id.dagger_btn_02, R.id.dagger_btn_03})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dagger_btn_01:
                startActivity(new Intent(this, A01SimpleActivity.class));
                break;
            case R.id.dagger_btn_02:
                startActivity(new Intent(this, A02Activity.class));
                break;
            case R.id.dagger_btn_03:
                startActivity(new Intent(this, A03Activity.class));
                break;
        }
    }
}
