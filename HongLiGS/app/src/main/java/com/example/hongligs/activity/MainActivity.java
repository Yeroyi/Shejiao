package com.example.hongligs.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;

import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hongligs.R;
import com.example.hongligs.app.BaseActivity;
import com.example.hongligs.fragment.HomepageFragment;
import com.example.hongligs.fragment.SettingFragment;
import com.example.hongligs.fragment.TodayFragment;
import com.example.hongligs.fragment.TongxunluFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private RadioButton rb_home;
    private RadioButton rb_pond;
    private ImageView rbAdd;
    private RadioButton rb_message;
    private RadioButton rb_me;

    private ArrayList<Fragment> mFargment;
    private FragmentManager mFragmentManager;
    private int currentItem = -1;
    private FrameLayout fragment_container;
    private long exitTime;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        iniData();
        initLister();
    }

    private void initLister() {
        rbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ReleaseDynamicActivity.class);
                startActivity(intent);

            }
        });

    }


    private void iniData() {
        mFargment = new ArrayList<>();
        HomepageFragment homepageFragment = new HomepageFragment();
        TongxunluFragment tongxunluFragment = new TongxunluFragment();
        TodayFragment todayFragment = new TodayFragment();
        SettingFragment settingFragment = new SettingFragment();
        mFargment.add(homepageFragment);
        mFargment.add(tongxunluFragment);
        mFargment.add(todayFragment);
        mFargment.add(settingFragment);
        mFragmentManager = getSupportFragmentManager();
        ChangeFragment(0);

    }

    private void initView() {
        rb_home = (RadioButton) findViewById(R.id.rb_home);
        rb_pond = (RadioButton) findViewById(R.id.rb_pond);
        rbAdd = (ImageView) findViewById(R.id.rbAdd);
        rb_message = (RadioButton) findViewById(R.id.rb_message);
        rb_me = (RadioButton) findViewById(R.id.rb_me);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rb_home.setOnClickListener(this);
        rb_me.setOnClickListener(this);
        rb_message.setOnClickListener(this);
        rb_pond.setOnClickListener(this);


        fragment_container = (FrameLayout) findViewById(R.id.fragment_container);
        fragment_container.setOnClickListener(this);

    }

    public void ChangeFragment(int i) {
        if (currentItem == i)
            return;
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (mFargment.get(i).isAdded()) {
            fragmentTransaction.hide(mFargment.get(currentItem)).show(mFargment.get(i));
        } else {
//             初始状态新建
            if (currentItem == -1) {
                fragmentTransaction.add(R.id.fragment_container, mFargment.get(i));
            } else {
//              非初始状态切换
                fragmentTransaction.hide(mFargment.get(currentItem)).add(R.id.fragment_container, mFargment.get(i));
            }
        }
        fragmentTransaction.commit();
        currentItem = i;


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (rb_home.isChecked()) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(this, "再按一次将退出应用", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }
        } else {
            rb_home.setChecked(true);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_home:

                ChangeFragment(0);
                break;

            case R.id.rb_pond:
                ChangeFragment(1);
                break;

            case R.id.rb_message:
                ChangeFragment(2);
                break;


            case R.id.rb_me:
                ChangeFragment(3);
                break;

        }

    }
}

