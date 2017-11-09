package com.archer.demos.greendao.db;

import com.archer.demos.MyApp;
import com.archer.demos.greendao.bean.Shop;
import com.archer.demos.greendao.bean.ShopDao;

import java.util.List;

/**
 * Created by Archer on 2017/11/8.
 */

public class LoveDAO {
    /**
     * 添加数据
     */
    public static void insertLove(Shop shop) {
        MyApp.getDaoInstant().getShopDao().insert(shop);
    }
    /**
     * 删除数据
     */
    public static void deleteLove(long id) {
        MyApp.getDaoInstant().getShopDao().deleteByKey(id);
    }

    /**
     * 更新数据
     */
    public static void updateLove(Shop shop) {
        MyApp.getDaoInstant().getShopDao().update(shop);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     */
    public static List<Shop> queryLove() {
        return MyApp.getDaoInstant().getShopDao().queryBuilder().where(ShopDao.Properties.Type.eq(Shop.TYPE_LOVE)).list();
    }
}
