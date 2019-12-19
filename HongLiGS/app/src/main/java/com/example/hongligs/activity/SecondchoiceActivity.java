package com.example.hongligs.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.example.hongligs.R;
import com.example.hongligs.adapter.SecondListAdapter;
import com.example.hongligs.bean.SecondChoice;
import com.example.hongligs.http.NetCallBack;
import com.example.hongligs.http.OkHttpUtils;
import com.example.hongligs.http.URL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondchoiceActivity extends AppCompatActivity {

    private ListView listView;
    private List<SecondChoice.TaglistBean> taglist;
    private SecondListAdapter secondListAdapter;


    // 二次选择
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondchoice);
        taglist = new ArrayList<>();
        initView();
        inidata();
    }

    private void inidata() {
// 二次筛选圈子
        Map<String, String> map = new HashMap<>();

        OkHttpUtils.getInstance(this).postMap(URL.SENDCHIOCED, map, new NetCallBack() {
            @Override
            public void onFailure(IOException e) {

            }

            @Override
            public void onResponse(String response, String type) {


                SecondChoice secondChoice = JSON.parseObject(response, SecondChoice.class);
                taglist.addAll(secondChoice.getTaglist());


                if (secondListAdapter==null){
                    secondListAdapter = new SecondListAdapter(taglist,SecondchoiceActivity.this);
                    listView.setAdapter(secondListAdapter);
                }else {
                    secondListAdapter.notifyDataSetChanged();
                }



            }
        }, "");

    }

    private void initView() {
        listView = findViewById(R.id.listview);



    }

}
