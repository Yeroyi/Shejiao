package com.example.hongligs.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.hongligs.R;
import com.example.hongligs.app.BaseActivity;
import com.example.hongligs.bean.Choosebean;
import com.example.hongligs.bean.NewOKBean;
import com.example.hongligs.http.NetCallBack;
import com.example.hongligs.http.OkHttpUtils;
import com.example.hongligs.http.URL;
import com.example.hongligs.utils.SPManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChooseCircleActivity extends BaseActivity {

    private List<Choosebean.CtlistBean> ctlist;
    private ArrayList<String> selectedList = new ArrayList<>();

    private TextView btn;
    private Gridadapter gridadapter;
    private GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_circle);
        initView();
        inidata();
    }

    private void newnext( ArrayList<String> selectedList) {

        Map<String, String> map = new HashMap<>();

        map.put("tags", JSON.toJSON(selectedList).toString());
       // map.put("age", age + "");


        OkHttpUtils.getInstance(this).postMap(URL.NEWNEXT, map, new NetCallBack() {
            @Override
            public void onFailure(IOException e) {

            }

            @Override
            public void onResponse(String response, String type) {
                NewOKBean newOKBean = JSON.parseObject(response, NewOKBean.class);


                if (newOKBean.getCode().equals("200")) {
                    Intent intent = new Intent(ChooseCircleActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ChooseCircleActivity.this, "失败了！", Toast.LENGTH_SHORT).show();
                }


            }
        },"");

    }


    private void inidata() {
        Map<String, String> map = new HashMap<>();

        OkHttpUtils.getInstance(this).postMap(URL.NEWCHOOSE, map, new NetCallBack() {
            @Override
            public void onFailure(IOException e) {

            }

            @Override
            public void onResponse(String response, String type) {
                Choosebean choosebean = JSON.parseObject(response, Choosebean.class);
                ctlist = choosebean.getCtlist();

                gridadapter = new Gridadapter(ctlist, ChooseCircleActivity.this, selectedList);
                gridView.setAdapter(gridadapter);
            }
        }, "");
    }

    private void initView() {

        btn = findViewById(R.id.btn);
        gridView = findViewById(R.id.gridView);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 如果此前是没选中状态 那么修改数据  并且添加到新的集合里面
                if (!ctlist.get(position).isSelectedState()) {
                    ctlist.get(position).setSelectedState(true);
                    selectedList.add(ctlist.get(position).getId());


                } else {
                    // 否则
                    ctlist.get(position).setSelectedState(false);
                    selectedList.remove(ctlist.get(position).getId());

                }
                gridadapter.notifyDataSetChanged();

            }


        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String choice = SPManager.getChoice(ChooseCircleActivity.this);

                if (selectedList.size()==0) {
                    Toast.makeText(ChooseCircleActivity.this, "请选择您喜欢的圈子！", Toast.LENGTH_SHORT).show();
                } else {

                    newnext(selectedList);
                }

            }
        });

    }


    public class Gridadapter extends BaseAdapter {
        private List<Choosebean.CtlistBean> ctlist;
        private Context context;
        private ArrayList<String> selectedList;

        public Gridadapter(List<Choosebean.CtlistBean> ctlist, Context context, ArrayList<String> selectedList) {
            this.ctlist = ctlist;
            this.context = context;
            this.selectedList = selectedList;
        }

        @Override
        public int getCount() {
            return ctlist.isEmpty() ? 0 : ctlist.size();
        }

        @Override
        public Object getItem(int i) {

            return ctlist.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if (view == null) {
                holder = new ViewHolder();
                view = LayoutInflater.from(context).inflate(R.layout.chose_item, null);
                holder.chose_image = view.findViewById(R.id.chose_image);
                holder.chose_text = view.findViewById(R.id.chose_text);
                holder.hook_img = view.findViewById(R.id.hook_img);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            Glide.with(context).load(ctlist.get(i).getBackground()).into(holder.chose_image);
            holder.chose_text.setText(ctlist.get(i).getName());

            if (ctlist.get(i).isSelectedState()) {

                holder.hook_img.setVisibility(View.VISIBLE);
                holder.chose_text.setTextColor(Color.parseColor("#ffffff"));

            } else {
                holder.hook_img.setVisibility(View.GONE);
                holder.chose_text.setTextColor(Color.parseColor("#FF333333"));
            }


            if (selectedList.size() >= 3) {
                btn.setVisibility(View.VISIBLE);
            } else {
                btn.setVisibility(View.GONE);
            }


            return view;
        }

        class ViewHolder {
            TextView chose_text;
            ImageView chose_image,hook_img;
        }
    }
}
