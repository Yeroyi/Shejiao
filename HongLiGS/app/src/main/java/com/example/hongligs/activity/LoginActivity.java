package com.example.hongligs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hongligs.R;
import com.example.hongligs.app.BaseActivity;
import com.example.hongligs.bean.loginbean;
import com.example.hongligs.http.NetCallBack;
import com.example.hongligs.http.OkHttpUtils;
import com.example.hongligs.http.URL;
import com.example.hongligs.utils.SPManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv;
    private EditText ed_phone;
    private TextView ed_yzm;
    private Button bt_login;
    private String phone;
    private String yzm;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }


    // 登录接口
    private void login() {

        String w = ed_phone.getText().toString();
        Map<String, String> map = new HashMap<>();
        map.put("phone", w);

        OkHttpUtils.getInstance(this).postMap(URL.REGISTER, map, new NetCallBack() {
            @Override
            public void onFailure(IOException e) {

            }

            @Override
            public void onResponse(String response, String type) {


                Gson gson = new Gson();
                loginbean loginbean = gson.fromJson(response, loginbean.class);

                if (loginbean.getCode().equals("200")) {
                    String uid = loginbean.getId();
                    Log.d("userId==", uid);
                    //请求成功以后：把后台反给的uid保存起来
                    SPManager.setUid(LoginActivity.this, uid);//第二个参数填后台的值

                    Intent intent = new Intent(LoginActivity.this, SexActivity.class);
                    startActivity(intent);

                    finish();
                }

            }
        }, "");


    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
        ed_phone = (EditText) findViewById(R.id.ed_phone);
        ed_yzm = (TextView) findViewById(R.id.ed_yzm);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
        ed_yzm.setOnClickListener(this);

        submit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:  //点击登陆做的逻辑


                if (ed_phone.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "手机号为空", Toast.LENGTH_SHORT).show();
                } else {
                    if (ed_yzm.getText().toString().trim().isEmpty()) {
                        Toast.makeText(this, "验证码为空", Toast.LENGTH_SHORT).show();
                    } else {
                        login();
                    }
                }
                break;

//发送验证码
            case R.id.ed_yzm://
                String s = ed_phone.getText().toString();
                Map<String, String> map = new HashMap<>();
                map.put("phone", s);

                OkHttpUtils.getInstance(this).postMap(URL.MESSAGE, map, new NetCallBack() {
                    @Override
                    public void onFailure(IOException e) {

                    }

                    @Override
                    public void onResponse(String response, String type) {

                        Log.d("response", response);
                        Toast.makeText(LoginActivity.this, "OK", Toast.LENGTH_SHORT).show();

                    }
                }, "");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

    private void submit() {
        // validate
        phone = ed_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        yzm = ed_yzm.getText().toString().trim();
        if (TextUtils.isEmpty(yzm)) {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
