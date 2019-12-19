package com.example.hongligs.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hongligs.R;

//  发布动态
public class ReleaseDynamicActivity extends AppCompatActivity {

    private RecyclerView RelasceRecyview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release_dynamic);
        initView();
        inidata();
    }

    private void inidata() {

    }

    private void initView() {
        RelasceRecyview = (RecyclerView) findViewById(R.id.RelasceRecyview);
    }
}
