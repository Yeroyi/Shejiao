package com.example.hongligs.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.androidkun.xtablayout.XTabLayout;
import com.example.hongligs.R;
import com.example.hongligs.adapter.FragtextAdapter;
import com.example.hongligs.adapter.LableRecyAdapter;
import com.example.hongligs.adapter.RecyAdapter;
import com.example.hongligs.bean.LableBean;
import com.example.hongligs.http.NetCallBack;
import com.example.hongligs.http.OkHttpUtils;
import com.example.hongligs.http.URL;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 * 动态广场
 */
public class DynamicFragment extends Fragment {

    private View view;
    private List<LableBean.TagsByUidBean> tagsByUid;
    private LableRecyAdapter lableRecyAdapter;
    private ViewPager Vp_Viewpager;
    private XTabLayout taxblayout;

    private FragtextAdapter fragmAdapterR;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        iniView();
        inidata();
        iniTable();


        return view;
    }

    private void inidata() {

    }

    private void iniView() {

        taxblayout = (XTabLayout) view.findViewById(R.id.taxblayout);
        Vp_Viewpager = view.findViewById(R.id.Vp_Viewpager);

        fragmAdapterR = new FragtextAdapter(getFragmentManager());
        Vp_Viewpager.setAdapter(fragmAdapterR);
        taxblayout.setupWithViewPager(Vp_Viewpager);
    }


    private void iniTable() {  // 筛选列表   这个就是


        Map<String, String> map = new HashMap<>();
        OkHttpUtils.getInstance(getActivity()).postMap(URL.DYNAMICLABLE, map, new NetCallBack() {
            @Override
            public void onFailure(IOException e) {
            }

            @Override
            public void onResponse(String response, String type) {
                //    wetherbeans = JSON.parseArray(response, wetherbean.class);
                LableBean lableBean = JSON.parseObject(response, LableBean.class);
                tagsByUid = lableBean.getTagsByUid();


                fragmAdapterR.addItem(lableBean.getTagsByUid());
                Vp_Viewpager.setAdapter(fragmAdapterR);
                taxblayout.setupWithViewPager(Vp_Viewpager);

                if (getActivity() != null) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                        }
                    });
                }

            }
        }, "");
    }


}

