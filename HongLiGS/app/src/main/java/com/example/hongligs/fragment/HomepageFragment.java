package com.example.hongligs.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.hongligs.R;
import com.example.hongligs.activity.SecondchoiceActivity;
import com.example.hongligs.bean.Bannerbean;
import com.example.hongligs.bean.SecondChoice;
import com.example.hongligs.http.NetCallBack;
import com.example.hongligs.http.OkHttpUtils;
import com.example.hongligs.http.URL;
import com.example.hongligs.view.NoScrollViewPager;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 *
 *  名字叫啥算了  你改主页面这个吧 主页面我是粘贴你这个页面的代码
 */
public class HomepageFragment extends Fragment implements OnBannerListener, View.OnClickListener, ViewPager.OnPageChangeListener {


    private View view;

    private Banner banner;

    private List<Fragment> fragmentLists;
    private ArrayList<String> list_path = new ArrayList<>();
    private ArrayList<String> list_title = new ArrayList<>();
    private TextView home_dt;

    private TextView home_hot;
    private View home_text;
    private View home_title;
    private NoScrollViewPager myVpview;
    private ImageView Image_shalou;

    public HomepageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ji_lu, container, false);
        initview();
        iniData();

        return view;

    }


    private void initBanner() {
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(2000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();
    }

    private void iniData() {
        Map<String, String> map = new HashMap<>();
        //map.put("phone", w);

        OkHttpUtils.getInstance(getActivity()).postMap(URL.BANNER, map, new NetCallBack() {
            @Override
            public void onFailure(IOException e) {

            }

            @Override
            public void onResponse(String response, String type) {
                List<Bannerbean> bannerbeans = JSON.parseArray(response, Bannerbean.class);

                for (int i = 0; i < bannerbeans.size(); i++) {

                    list_path.add(bannerbeans.get(i).getUrl());
                    list_title.add(bannerbeans.get(i).getId());
                }
                Log.d(" list_path.size();", list_path.size() + "");
                initBanner();
            }
        }, "");

    }

    private void initview() {
        home_dt = view.findViewById(R.id.home_dt);
        home_dt.setOnClickListener(this);
        home_hot = view.findViewById(R.id.home_hot);
        home_hot.setOnClickListener(this);
        home_text = view.findViewById(R.id.home_text);
        home_title = view.findViewById(R.id.home_title);
        banner = view.findViewById(R.id.banner);
        Image_shalou = view.findViewById(R.id.Image_shalou);

        myVpview = view.findViewById(R.id.myVpview);

        fragmentLists = new ArrayList<>();

        fragmentLists.add(new DynamicFragment());
        fragmentLists.add(new HotFragment());
//        fragmentList.add(new FoodFragment());

        FragmentManager fm = getFragmentManager();
        MyViewPageAdapter myPagerAdapter = new MyViewPageAdapter(fm,fragmentLists);
        myVpview.setAdapter(myPagerAdapter);
        myVpview.setCurrentItem(0);
        myVpview.setOffscreenPageLimit(1);//加载多少个页面
        myVpview.addOnPageChangeListener(this);


        Image_shalou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SecondchoiceActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_dt: //动态广场
                myVpview.setCurrentItem(0, false);
                break;
            case R.id.home_hot://热门群聊
                myVpview.setCurrentItem(1, false);
                break;

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        TagShow();
        switch (position) {
            case 0:
                home_dt.setTextColor(getResources().getColor(R.color.black));
                home_dt.setTextSize(18);
                home_text.setVisibility(View.VISIBLE);
                break;
            case 1:
                home_hot.setTextColor(getResources().getColor(R.color.black));
                home_hot.setTextSize(18);
                home_title.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void TagShow() {
        home_dt.setTextSize(18);
        home_dt.setTextColor(getActivity().getResources().getColor(R.color.gray));
        home_text.setVisibility(View.INVISIBLE);

        home_hot.setTextSize(18);
        home_hot.setTextColor(getActivity().getResources().getColor(R.color.gray));
        home_title.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }

    //轮播图的监听方法
    @Override
    public void OnBannerClick(int position) {
        Log.i("tag", "你点了第" + position + "张轮播图");
    }


    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }


    //
    //viewpager适配器
    class MyViewPageAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentLists;

        public MyViewPageAdapter(FragmentManager fm, List<Fragment> fragmentLists) {
            super(fm);

            this.fragmentLists = fragmentLists;
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentLists.get(i);
        }

        @Override
        public int getCount() {
            return fragmentLists.size();
        }
    }
}

