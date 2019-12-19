package com.example.hongligs.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.hongligs.R;
import com.example.hongligs.app.BaseActivity;
import com.example.hongligs.bean.ExtOKBean;
import com.example.hongligs.bean.Timebean;
import com.example.hongligs.http.NetCallBack;
import com.example.hongligs.http.OkHttpUtils;
import com.example.hongligs.http.URL;
import com.example.hongligs.utils.SPManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SexActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTvYear;
    private List<String> name = new ArrayList<>();
    private String mSelectText = "";
    private WheelView wheelView;
    private TextView button_next;


    private LinearLayout lin_nv, lin_nan;
    private ImageView image_nv, image_nan;
    private TextView text_nv, text_nan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex);
        initView();
        inidata();

    }

    //点击下一步
    private void ininextdata(String gender, String age) {

        Map<String, String> map = new HashMap<>();

        map.put("gender", gender + "");
        map.put("age", age + "");


        OkHttpUtils.getInstance(this).postMap(URL.Next, map, new NetCallBack() {
            @Override
            public void onFailure(IOException e) {

            }

            @Override
            public void onResponse(String response, String type) {


                ExtOKBean extOKBean = JSON.parseObject(response, ExtOKBean.class);


                if (extOKBean.getCode().equals("200")) {
                    Intent intent = new Intent(SexActivity.this, ChooseCircleActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SexActivity.this, "失败了！", Toast.LENGTH_SHORT).show();
                }
            }
        }, "");

    }


    private void initView() {
        mTvYear = findViewById(R.id.tv_year);
        wheelView = findViewById(R.id.wheel);

        button_next = findViewById(R.id.button_next);
        button_next.setOnClickListener(this);

        lin_nv = findViewById(R.id.lin_nv);
        image_nv = findViewById(R.id.image_nv);
        text_nv = findViewById(R.id.text_nv);
        //
        lin_nan = findViewById(R.id.lin_nan);
        image_nan = findViewById(R.id.image_nan);
        text_nan = findViewById(R.id.text_nan);

        lin_nv.setOnClickListener(this);
        lin_nan.setOnClickListener(this);

        //默认
        image_nv.setImageResource(R.mipmap.lightgr);
        text_nv.setTextColor(Color.parseColor("#FFFFFF"));

        SPManager.setChoice(this, "2");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_next:
                String choice = SPManager.getChoice(this);

                if (TextUtils.isEmpty(mSelectText)) {
                    Toast.makeText(this, "请选择年龄！", Toast.LENGTH_SHORT).show();
                } else {

                    ininextdata(choice, mSelectText);
                }


                break;


            case R.id.lin_nv:  //点击妞的头像 hitboy hitgirl
                SPManager.setChoice(this, "2");
                image_nv.setImageResource(R.mipmap.lightgr);
                text_nv.setTextColor(Color.parseColor("#FFFFFF"));
                image_nan.setImageResource(R.mipmap.hitboy);
                text_nan.setTextColor(Color.parseColor("#79818D"));
                break;
            case R.id.lin_nan:  //点击男人头像
                SPManager.setChoice(this, "1");
                image_nan.setImageResource(R.mipmap.lightboy);
                text_nan.setTextColor(Color.parseColor("#FFFFFF"));
                image_nv.setImageResource(R.mipmap.hitgirl);
                text_nv.setTextColor(Color.parseColor("#79818D"));
                break;


        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        SPManager.setChoice(this, "");
    }

    private void inidata() {

        Map<String, String> map = new HashMap<>();
        map.put("type", "age");
        OkHttpUtils.getInstance(this).postMap(URL.XTime, map, new NetCallBack() {


            @Override
            public void onFailure(IOException e) {

            }

            @Override
            public void onResponse(String response, String type) {

                Timebean timebean = JSON.parseObject(response, Timebean.class);

                List<Timebean.DlistBean> dlist = timebean.getDlist();
                Log.d("timebeans==", dlist.size() + "");

                for (int i = 0; i < dlist.size(); i++) {

                    name.add(dlist.get(i).getVal());
                }
//                showDialog(mTvYear, name, timebeans.size());

                showChoiceDialog(name, mTvYear, name.size(),
                        new WheelView.OnWheelViewListener() {
                            @Override
                            public void onSelected(int selectedIndex, String item) {
                                mSelectText = item;
                            }
                        });


            }
        }, "");

    }

    private void showChoiceDialog(List<String> name, final TextView textView, int selected, WheelView.OnWheelViewListener listener) {

        mSelectText = "";

        wheelView.setOffset(2);
        wheelView.setSeletion(selected);
        wheelView.setItems(name);
        wheelView.setOnWheelViewListener(listener);

        textView.setText(mSelectText);
        textView.setTextColor(getResources().getColor(R.color.ffffff));


    }
}
