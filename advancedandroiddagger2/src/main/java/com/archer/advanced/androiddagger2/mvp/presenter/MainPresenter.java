package com.archer.advanced.androiddagger2.mvp.presenter;

import com.archer.advanced.androiddagger2.mvp.activity.MainActivity;
import com.archer.advanced.androiddagger2.mvp.contract.MainContract;
import com.archer.advanced.androiddagger2.mvp.model.MainModel;

import javax.inject.Inject;

/**
 * Created by Archer on 2018/4/18.
 */

public class MainPresenter implements MainContract.Presenter {
    private final MainActivity view;
    private final MainModel model;

    @Inject
    public MainPresenter(MainActivity view, MainModel model) {
        this.view = view;
        this.model = model;
    }

    public void requestHttp() {
        view.onGetMessage(model.returnMessage());
    }
}
