package com.example.hongligs.adapter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hongligs.bean.LableBean;
import com.example.hongligs.fragment.DTRecommendFragment;

import java.util.ArrayList;
import java.util.List;

public class FragtextAdapter extends FragmentPagerAdapter {

    private ArrayList<LableBean.TagsByUidBean> titles = new ArrayList<>();

    public FragtextAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addItem(LableBean.TagsByUidBean itemData) {
        titles.add(itemData);
    }

    public void addItem(List<LableBean.TagsByUidBean> itemData) {
        titles.addAll(itemData);
    }

    @Override
    public Fragment getItem(int position) {
        DTRecommendFragment fragment = new DTRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("bean", titles.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return titles != null ? titles.size() : 0;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position).getName();
    }
}
