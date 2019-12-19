package com.example.hongligs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.hongligs.R;

import java.util.ArrayList;

//换个位置   打开主页
public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager vp;
    private LinearLayout liner;
    private Button button;


    private int[] arr = {R.mipmap.a, R.mipmap.b, R.mipmap.c};
    private ArrayList<ImageView> initdata;
    private ArrayList<ImageView> listdata;
    private int guide;


    /**
     * 引导页
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);


        if (guide == 1) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

        initView();
        initData();
        initAdapter();
//        initfirst();
        initListerner();

    }

//    private void initfirst() {
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                Boolean isFirst = SharePreUtil.getBoolean(getApplicationContext(), SharePreUtil.ConstantValue.ISFIRST, true);
//                if (isFirst) {
//                    //进入包含了viewpager那个导航界面
//                    Intent intent = new Intent(getApplicationContext(), GuideActivity.class);
//                    startActivity(intent);
//                    //将isFirst改为false,并且在本地持久化
////                    SharePreUtil.saveBoolean(getApplicationContext(), SharePreUtil.ConstantValue.ISFIRST, false);
//                } else {
//
////                    SharePreUtil.saveBoolean(getApplicationContext(), SharePreUtil.ConstantValue., false);
//                    //进入应用程序主界面
//
//
//
//                }
//                finish();
//            }
//        }, 2000);
//    }


    private void initListerner() {
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < 3; i++) {
                    if (position == i) {
                        listdata.get(i).setImageResource(R.drawable.shape_selected);
                    } else {
                        listdata.get(i).setImageResource(R.drawable.shape_north);
                    }

                    if (position == initdata.size() - 1) {

                        liner.setVisibility(View.GONE);
                        button.setVisibility(View.VISIBLE);
                    } else {
                        liner.setVisibility(View.VISIBLE);
                        button.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initAdapter() {
//        FragAdapter adapter = new FragAdapter(initdata);
//        vp.setAdapter(adapter);
//        vp.setCurrentItem(0);
    }


    private void initData() {
        initdata = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ImageView image = new ImageView(this);
            image.setImageResource(arr[i]);
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            initdata.add(image);
        }
        listdata = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.leftMargin = 10;
            layoutParams.rightMargin = 10;
            layoutParams.height = 18;
            layoutParams.width = 18;
            if (i == 0) {
                imageView.setImageResource(R.drawable.shape_selected);

            } else {
                imageView.setImageResource(R.drawable.shape_north);

            }
            liner.addView(imageView, layoutParams);
            listdata.add(imageView);


        }

    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        liner = (LinearLayout) findViewById(R.id.liner);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);

        vp = (ViewPager) findViewById(R.id.vp);
        vp.setOnClickListener(this);
        liner = (LinearLayout) findViewById(R.id.liner);
        liner.setOnClickListener(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:

                Intent intent = new Intent(GuideActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;

        }
    }
}
