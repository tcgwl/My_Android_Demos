package com.archer.demos.largeimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.archer.demos.R;
import com.archer.demos.largeimage.view.LargeImageView;

import java.io.IOException;
import java.io.InputStream;

public class LargeImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_image);

        LargeImageView largeImageView = (LargeImageView) findViewById(R.id.id_largeImageView);
        try {
            InputStream inputStream = getAssets().open("qm.jpg");
            largeImageView.setInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
