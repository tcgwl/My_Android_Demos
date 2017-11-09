package com.archer.demos.greendao.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.archer.demos.R;
import com.archer.demos.greendao.bean.Shop;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Archer on 2017/11/8.
 */

public class ShopListAdapter extends RecyclerView.Adapter<ShopListAdapter.MyViewHolder> {
    private Context mContext;
    private List<Shop> mShopList;

    public ShopListAdapter(List<Shop> data) {
        mShopList = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_shop_list, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Shop shop = mShopList.get(position);
        Glide.with(mContext).load(shop.getImage_url()).into(holder.iv_shop);
        holder.tv_name.setText(shop.getName());
        holder.tv_price.setText(shop.getPrice() + "");
        holder.tv_price_discount.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.tv_sell_num.setText("已售" + shop.getSell_num() + "件");
    }

    @Override
    public int getItemCount() {
        return mShopList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name, tv_price, tv_price_discount, tv_sell_num;
        private ImageView iv_shop;

        public MyViewHolder(View view) {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_price = (TextView) view.findViewById(R.id.tv_price);
            tv_price_discount = (TextView) view.findViewById(R.id.tv_price_discount);
            tv_sell_num = (TextView) view.findViewById(R.id.tv_sell_num);
            iv_shop = (ImageView) view.findViewById(R.id.iv_shop);
        }
    }
}
