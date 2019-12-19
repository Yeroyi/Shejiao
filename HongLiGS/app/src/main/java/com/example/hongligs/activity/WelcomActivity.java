package com.example.hongligs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.hongligs.R;
import com.example.hongligs.app.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomActivity extends BaseActivity {

    private ImageView Image_vIEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        initView();
    }

    private void initView() {
        Image_vIEW = (ImageView) findViewById(R.id.Image_vIEW);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        },3000);
    }
}
