package com.example.hongligs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hongligs.R;
import com.example.hongligs.utils.SPManager;

//启动页面
public class StartActivity extends AppCompatActivity {

    private boolean isFrist;  //判断是否是第一次进入程序
    private Handler handler;  //延时跳转
    private Intent intent;  //意图对象

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity);

        isFrist = SPManager.isFirst(this, true);
        intent = new Intent();
        handler = new Handler();
        if (isFrist) {

            //是第一次进入程序
            handler.postDelayed(runnable, 1000);
        } else {  //不是第一次进入程序

            handler.postDelayed(runnable, 1000);
        }

    }

    //延时跳转的对象
    private Runnable runnable = new Runnable() {

        @Override
        public void run() {
            if (isFrist) {  //是第一次进入程序,跳入到导航页
                intent.setClass(StartActivity.this, GuideActivityA.class);
            } else {  //不是第一次进入程序,跳入到主页

                String userId = SPManager.getUid(StartActivity.this);

                Log.d("userId==",userId);
                if (userId == null || userId.equals("")) {
                    intent.setClass(StartActivity.this, LoginActivity.class);
                } else {
                    intent.setClass(StartActivity.this, MainActivity.class);
                }


            }
            startActivity(intent);
            StartActivity.this.finish();
        }
    };
}
