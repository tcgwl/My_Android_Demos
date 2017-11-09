package com.archer.demos.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.archer.demos.R;
import com.archer.demos.greendao.adapter.ShopListAdapter;
import com.archer.demos.greendao.bean.Shop;
import com.archer.demos.greendao.db.LoveDAO;

import java.util.ArrayList;
import java.util.List;

public class GreenDaoDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Button addBtn, deleteBtn, updateBtn, queryBtn;
    private RecyclerView contentRecyclerView;
    private ShopListAdapter mAdapter;
    private List<Shop> mShopList;
    private static int i = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao_demo);
        initViews();
        queryData();
    }

    private void initViews() {
        addBtn = (Button) findViewById(R.id.btn_add);
        deleteBtn = (Button) findViewById(R.id.btn_delete);
        updateBtn = (Button) findViewById(R.id.btn_update);
        queryBtn = (Button) findViewById(R.id.btn_query);
        contentRecyclerView = (RecyclerView) findViewById(R.id.recycleView_content);
        addBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        queryBtn.setOnClickListener(this);
    }

    private void addData() {
        Shop shop = new Shop();
        shop.setType(Shop.TYPE_LOVE);
        shop.setAddress("广东深圳");
        shop.setImage_url("https://img.alicdn.com/bao/uploaded/i2/TB1N4V2PXXXXXa.XFXXXXXXXXXX_!!0-item_pic.jpg_640x640q50.jpg");
        shop.setPrice("19.40");
        shop.setSell_num(15263);
        shop.setName("正宗梅菜扣肉 聪厨梅干菜扣肉 家宴常备方便菜虎皮红烧肉 2盒包邮" + i++);
        LoveDAO.insertLove(shop);
        queryData();
    }

    private void deleteData() {
        if (!mShopList.isEmpty()) {
            LoveDAO.deleteLove(mShopList.get(0).getId());
            queryData();
        }
    }
    private void updateData() {
        if (!mShopList.isEmpty()) {
            Shop shop = mShopList.get(0);
            shop.setName("我是修改后的名字.");
            LoveDAO.updateLove(shop);
            queryData();
        }
    }
    private void queryData() {
        mShopList = new ArrayList<>();
        mShopList = LoveDAO.queryLove();
        Log.e(TAG, "mShopList.size: " + mShopList.size());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        contentRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ShopListAdapter(mShopList);
        contentRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                addData();
                break;
            case R.id.btn_delete:
                deleteData();
                break;
            case R.id.btn_update:
                updateData();
                break;
            case R.id.btn_query:
                queryData();
                break;
            default:
        }
    }
}
