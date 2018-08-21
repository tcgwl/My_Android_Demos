package com.archer.demos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.archer.demos.bean.ClassBean;
import com.archer.demos.dagger.DaggerSampleActivity;
import com.archer.demos.dialogfragment.DialogFragmentSampleActivity;
import com.archer.demos.diyview.DiyViewActivity;
import com.archer.demos.filepath.ChooseFileActivity;
import com.archer.demos.greendao.GreenDaoDemoActivity;
import com.archer.demos.largeimage.LargeImageActivity;
import com.archer.demos.mvppractice.LoginActivity;
import com.archer.demos.mvpretrofitrxjava.ui.activity.MVPBookActivity;
import com.archer.demos.notification.NotificationSampleActivity;

public class CategoryActivity extends AppCompatActivity {
    private ListView mListView;

    private LayoutInflater mInflater;

    private ClassBean[] CLAZZES = new ClassBean[] {
                    new ClassBean(MVPBookActivity.class, "搭建MVP+Retrofit+RxJava网络请求框架"),
                    new ClassBean(LoginActivity.class, "MVP简单练习"),
                    new ClassBean(GreenDaoDemoActivity.class, "GreenDao-购物车练习"),
                    new ClassBean(LargeImageActivity.class, "高清加载巨图方案，拒绝压缩图片"),
                    new ClassBean(DiyViewActivity.class, "自定义View练习"),
                    new ClassBean(DaggerSampleActivity.class, "Dagger练习"),
                    new ClassBean(NotificationSampleActivity.class, "Android 8.0通知栏的适配"),
                    new ClassBean(DialogFragmentSampleActivity.class, "DialogFragment示例"),
                    new ClassBean(ChooseFileActivity.class, "获取文件真实路径")
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInflater = LayoutInflater.from(this);

        mListView = (ListView) findViewById(R.id.id_listView);

        mListView.setAdapter(new ArrayAdapter<ClassBean>(this, -1, CLAZZES) {
                                 @Override
                                 public View getView(int position, View convertView, ViewGroup parent) {
                                     ClassBean bean = getItem(position);
                                     if (convertView == null) {
                                         convertView = mInflater.inflate(R.layout.item_category, parent, false);
                                     }
                                     TextView titleTv = (TextView) convertView.findViewById(R.id.id_title);
                                     TextView contentTv = (TextView) convertView.findViewById(R.id.id_content);
                                     titleTv.setText(bean.className.getSimpleName());
                                     contentTv.setText(bean.content);
                                     return convertView;
                                 }
                             }

        );

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CategoryActivity.this, CLAZZES[position].className);
                intent.putExtra(BaseContentActivity.TITLE, CLAZZES[position].className.getSimpleName());
                startActivity(intent);
            }
        });
    }
}
