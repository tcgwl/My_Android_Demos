package com.archer.advanced.androiddagger2.mvp.model;

import com.archer.advanced.androiddagger2.mvp.contract.MainContract;

import javax.inject.Inject;

/**
 * Created by Archer on 2018/4/18.
 */

public class MainModel implements MainContract.Model {
    @Inject
    public MainModel() {
    }

    public String returnMessage() {
        return "main-model";
    }
}
