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

import com.archer.demos.largeimage.LargeImageActivity;

public class CategoryActivity extends AppCompatActivity {
    private ListView mListView;

    private LayoutInflater mInflater;

    private Class[] CLAZZES = new Class[] {
                    LargeImageActivity.class,
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInflater = LayoutInflater.from(this);

        mListView = (ListView) findViewById(R.id.id_listView);

        mListView.setAdapter(new ArrayAdapter<Class>(this, -1, CLAZZES) {
                                 @Override
                                 public View getView(int position, View convertView, ViewGroup parent) {
                                     String title = getItem(position).getSimpleName();
                                     if (convertView == null) {
                                         convertView = mInflater.inflate(R.layout.item_category, parent, false);
                                     }
                                     TextView tv = (TextView) convertView.findViewById(R.id.id_title);
                                     tv.setText(title);
                                     return convertView;
                                 }
                             }

        );

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CategoryActivity.this, CLAZZES[position]);
                intent.putExtra(BaseContentActivity.TITLE, CLAZZES[position].getSimpleName());
                startActivity(intent);
            }
        });
    }
}
