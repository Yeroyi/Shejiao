package com.example.hongligs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.hongligs.R;
import com.example.hongligs.app.BaseActivity;
import com.example.hongligs.utils.SPManager;

import java.util.ArrayList;
import java.util.List;

public class GuideActivityA extends BaseActivity implements View.OnClickListener {
    private ViewPager viewPager; // 切换引导页的控件
    private List<View> viewList; // 存放引导页的布局
    private ImageView imageOne, imageTwo; // 引导页的第一张和第二张图
    private View viewThree; // 引导页第三张的布局
    private Button btnGo; // 立即体验的按钮
    private Intent intent; // 意图对象


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guidea);

        initView();

    }

    private void initView() {
        SPManager.setSyIsFirst(GuideActivityA.this, true);
        intent = new Intent();
        viewList = new ArrayList<View>(); // 存放引导页的布局
        viewPager = (ViewPager) findViewById(R.id.viewPager); // 切换引导页的控件
        imageOne = new ImageView(GuideActivityA.this);
        imageOne.setBackgroundResource(R.mipmap.aa); //第一张图片
        imageTwo = new ImageView(GuideActivityA.this);
        imageTwo.setBackgroundResource(R.mipmap.bb); //第two
        viewThree = LayoutInflater.from(GuideActivityA.this).inflate(
                R.layout.layout_viewthree, null); //第三张，带按钮的
        btnGo = (Button) viewThree.findViewById(R.id.btnGo); // 立即体验的按钮
        viewList.add(imageOne);
        viewList.add(imageTwo);
        viewList.add(viewThree);
        // 绑定适配器
        viewPager.setAdapter(new ViewPagerAdapter());

        btnGo.setOnClickListener(this); // 立即体验的按钮
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnGo: // 立即体验的按钮

                SPManager.setIsFirst(this, false);
                intent.setClass(GuideActivityA.this, LoginActivity.class);
                startActivity(intent);
                this.finish();
                break;

        }
    }


    /**
     * 引导页滑动的适配器
     */
    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

    }
}
