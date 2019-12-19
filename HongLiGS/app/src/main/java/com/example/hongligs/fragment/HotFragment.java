package com.example.hongligs.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.example.hongligs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * 热门群聊
 */
public class HotFragment extends Fragment {


    private XTabLayout taxsblayout;
    private ViewPager Vp_Viewpager;
    private View inflate;
    private List<Fragment> fragments;
    private List<String> titless;

    public HotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_hot, container, false);
        iniview();
        inidata();
        return inflate;
    }
    private void inidata() {


        fragments = new ArrayList<>();
        titless = new ArrayList<>();


        fragments.add(new DTRecommendFragment());
        fragments.add(new DTAppearanceFragment());
        fragments.add(new DTBMobilegameFragment());
        fragments.add(new DTiCosypalyFragment());




        titless.add("推荐");
        titless.add("交友扩利");
        titless.add("游戏日常");
        titless.add("运动健身");



    }

    private void iniview() {

        taxsblayout = (XTabLayout) inflate.findViewById(R.id.taxsblayout);
        Vp_Viewpager = (ViewPager) inflate.findViewById(R.id.Vp_Viewpager);
    }

}
