package com.example.hongligs.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.hongligs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TongxunluFragment extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private View view;
    private TextView home_tv1, home_tv2;  //标签
    private View home_view1, home_view2;
    private ViewPager myVp;
    private List<Fragment> fragmentList;

    public TongxunluFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tongxunlu, container, false);
        initView();
        return view;
    }

    private void initView() {

        myVp = view.findViewById(R.id.myVp);
        home_tv1 = view.findViewById(R.id.home_tv1);
        home_tv1.setOnClickListener(this);
        home_tv2 = view.findViewById(R.id.home_tv2);
        home_tv2.setOnClickListener(this);
        home_view1 = view.findViewById(R.id.home_view1);
        home_view2 = view.findViewById(R.id.home_view2);


        fragmentList = new ArrayList<>();

        fragmentList.add(new TuiJianFragment());
        fragmentList.add(new NearbyFragment());
//        fragmentList.add(new FoodFragment());

        FragmentManager fm = getActivity().getSupportFragmentManager();
        MyViewPageAdapter myPagerAdapter = new MyViewPageAdapter(fm, fragmentList);
        myVp.setAdapter(myPagerAdapter);
        myVp.setCurrentItem(0);
        myVp.setOffscreenPageLimit(1);//加载多少个页面  
        myVp.addOnPageChangeListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_tv1: //页面一
                myVp.setCurrentItem(0, false);
                break;
            case R.id.home_tv2://页面二
                myVp.setCurrentItem(1, false);
                break;

        }
    }

    private void TagShow() {
        home_tv1.setTextSize(14);
        home_tv1.setTextColor(getActivity().getResources().getColor(R.color.green));
        home_view1.setVisibility(View.INVISIBLE);

        home_tv2.setTextSize(14);
        home_tv2.setTextColor(getActivity().getResources().getColor(R.color.green));
        home_view2.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //滑动监听
    @Override
    public void onPageSelected(int position) {
        TagShow();
        switch (position) {
            case 0:
                home_tv1.setTextColor(getResources().getColor(R.color.yellow));
                home_tv1.setTextSize(16);
                home_view1.setVisibility(View.VISIBLE);
                break;
            case 1:
                home_tv2.setTextColor(getResources().getColor(R.color.yellow));
                home_tv2.setTextSize(16);
                home_view2.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //viewpager适配器
    class MyViewPageAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList;

        public MyViewPageAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
