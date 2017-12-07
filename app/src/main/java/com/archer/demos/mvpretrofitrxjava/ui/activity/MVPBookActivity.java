package com.archer.demos.mvpretrofitrxjava.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.archer.demos.R;
import com.archer.demos.mvpretrofitrxjava.service.entity.Book;
import com.archer.demos.mvpretrofitrxjava.service.presenter.BookPresenter;
import com.archer.demos.mvpretrofitrxjava.service.view.BookView;

public class MVPBookActivity extends AppCompatActivity {
    private TextView resultTv;
    private Button sendBtn;
    private BookPresenter mBookPresenter = new BookPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpbook);
        initView();
        initData();
    }

    private void initView() {
        resultTv = (TextView) findViewById(R.id.tv_result);
        sendBtn = (Button) findViewById(R.id.btn_send);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBookPresenter.getSearchBooks("金瓶梅", null, 0, 1);
            }
        });
    }

    private void initData() {
        mBookPresenter.onCreate();
        mBookPresenter.attachView(mBookView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBookPresenter.onStop();
    }

    private BookView mBookView = new BookView() {
        @Override
        public void onSuccess(Book book) {
            resultTv.setText(book.toString());
        }

        @Override
        public void onFailure(String message) {
            Toast.makeText(MVPBookActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };
}
