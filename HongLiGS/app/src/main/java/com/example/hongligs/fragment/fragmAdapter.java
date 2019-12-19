package com.example.hongligs.fragment;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hongligs.bean.LableBean;

import java.util.ArrayList;
import java.util.List;


public class fragmAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public fragmAdapter(FragmentManager fm, List<Fragment> fragments, ArrayList<LableBean.TagsByUidBean> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    private ArrayList<LableBean.TagsByUidBean> titles;




    public fragmAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position).getName();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
