package com.example.hongligs.fragment;


import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.alibaba.fastjson.JSON;
import com.example.hongligs.R;
import com.example.hongligs.adapter.RemmodAdapter;
import com.example.hongligs.bean.LableBean;
import com.example.hongligs.bean.PtrClassicListFooter;
import com.example.hongligs.bean.PtrClassicListHeader;
import com.example.hongligs.bean.PtrClassicRefreshLayout;
import com.example.hongligs.bean.RemmondBean;
import com.example.hongligs.http.NetCallBack;
import com.example.hongligs.http.OkHttpUtils;
import com.example.hongligs.http.URL;
import com.example.hongligs.utils.DividerItemDecoration;
import com.example.hongligs.utils.SPManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * 热门推荐
 */
public class DTRecommendFragment extends Fragment {

    private int pagenum = 1;//
    private RecyclerView mRecyview;
    private View inflate;
    private List<RemmondBean.DlistBean> dlist;
    private RemmodAdapter remmodAdapter;
    private RemmondBean remmondBean;
    private PtrClassicRefreshLayout fragment_consultation_ptrr;

    public DTRecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_dtrecommend, container, false);

        iniView();
        iniData();
        return inflate;
    }

    private void iniData() {
        //这是用的网络框架
        Map<String, String> map = new HashMap<>();
        Bundle arguments = getArguments();
        LableBean.TagsByUidBean bean = arguments.getParcelable("bean");
        map.put("tags", bean.getId());
        map.put("currentPage", "1");
        map.put("uid", SPManager.getUid(getActivity()));
        OkHttpUtils.getInstance(getActivity()).postMap(URL.Recommend, map, new NetCallBack() {

            private StaggeredGridLayoutManager staggeredGridLayoutManager;

            @Override
            public void onFailure(IOException e) {

            }

            @Override
            public void onResponse(String response, String type) {

                remmondBean = JSON.parseObject(response, RemmondBean.class);
                dlist = remmondBean.getDlist();
                if(remmodAdapter==null){
                    remmodAdapter = new RemmodAdapter(getActivity(), dlist);
                    staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                    mRecyview.setLayoutManager(staggeredGridLayoutManager);
                    mRecyview.setAdapter(remmodAdapter);
                }else {
                    remmodAdapter.notifyDataSetChanged();
                }

            }
        }, "");


    }

    private void iniView() {
        mRecyview = inflate.findViewById(R.id.mRecyview);
        fragment_consultation_ptrr= inflate.findViewById(R.id.fragment_consultation_ptrr);


//        //刷新的代码
//
//        //      分割线用
//        mRecyview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
//        mRecyview.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//
////        / /头部阻尼系数
//        fragment_consultation_ptrr.setResistanceHeader(1.7f);
//// 底部阻尼系数
//        fragment_consultation_ptrr.setResistanceFooter(1.7f);
//// 默认1.2f，移动达到头部高度1.2倍时触发刷新操作
//        fragment_consultation_ptrr.setRatioOfHeaderHeightToRefresh(1.2f);
//// 头部回弹时间
//        fragment_consultation_ptrr.setDurationToCloseHeader(1000);
//// 底部回弹时间
//        fragment_consultation_ptrr.setDurationToCloseFooter(1000);
//// 释放刷新
//        fragment_consultation_ptrr.setPullToRefresh(false);
//// 释放时恢复到刷新状态的时间
//        fragment_consultation_ptrr.setDurationToBackHeader(200);
//        fragment_consultation_ptrr.setDurationToBackFooter(200);
//
//
//        // ------------------------------  刷新方法-----------------------------------
//
//        PtrClassicListHeader header = new PtrClassicListHeader(getContext());
//        header.setLastUpdateTimeRelateObject(this);
//        PtrClassicListFooter footer = new PtrClassicListFooter(getContext());
//        footer.setLastUpdateTimeRelateObject(this);
//        fragment_consultation_ptrr.setFooterView(footer);
//        fragment_consultation_ptrr.addPtrUIHandler(footer);
////
//        fragment_consultation_ptrr.setHeaderView(header);
//        fragment_consultation_ptrr.addPtrUIHandler(header);
//
//        fragment_consultation_ptrr.setPtrHandler(new PtrDefaultHandler2() {
//            @Override
//            public void onLoadMoreBegin(PtrFrameLayout frame) {
//                //上拉加载
//                pagenum++;  //++
//                iniData();
//                fragment_consultation_ptrr.refreshComplete();
//            }
//
//            @Override
//            public void onRefreshBegin(PtrFrameLayout frame) {
//                // 下拉刷新
//                pagenum = 1;
//                dlist.clear(); //清空集合
//
//                iniData();
//                fragment_consultation_ptrr.refreshComplete();
//            }
//        });
        }

}
