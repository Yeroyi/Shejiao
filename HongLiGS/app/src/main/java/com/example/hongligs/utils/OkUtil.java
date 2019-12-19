package com.example.hongligs.utils;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by on 2018/6/28.
 */

public class OkUtil {

    private final String TAG ="OkUtil";
    private static OkUtil mInstance;
    private Handler handler = new Handler(Looper.getMainLooper());
    OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(new LogInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build();
    /**
     * 单例模式获取OkUtil
     * @return
     */
    public static OkUtil getInstance() {
        if (mInstance == null) {
            synchronized (OkUtil.class) {
                if (mInstance == null) {
                    mInstance = new OkUtil();
                }
            }
        }
        return mInstance;
    }
    public void postMap(String url, Map<String, String> map) {
        FormBody.Builder builder = new FormBody.Builder();
        //遍历map
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.add(entry.getKey(), entry.getValue().toString());
            }
        }
        RequestBody body = builder.build();
        final Request request = new Request.Builder().url(url).post(body).build();
        new OkHttpClient().newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "失败"+e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(TAG, "成功");
            }
        });

    }
    public void postMaps(String url,Map<String,String> map,final HttpCallBack callBack){
        FormBody.Builder builder=new FormBody.Builder();

        //遍历map
        if(map!=null){
            for (Map.Entry<String,String> entry : map.entrySet()){
                builder.add(entry.getKey(), entry.getValue().toString());
            }
        }
        RequestBody body = builder.build();
        Request request = new Request.Builder().url(url).post(body).build();
        OnStart(callBack);
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                OnError(callBack,e.getMessage());
                Log.e(TAG, "onFailure: "+e.getMessage() );
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(TAG, "成功1");
                if(response.isSuccessful()){
                    onSuccess(callBack,response.body().string());
                }else{
                    OnError(callBack, response.message());
                }
            }
        });
    }


    public void OnStart(HttpCallBack callBack){
        if(callBack!=null){
            callBack.onstart();
        }
    }
    public void onSuccess(final HttpCallBack callBack,final String data){
        if(callBack!=null){
            handler.post(new Runnable() {
                @Override
                public void run() {//在主线程操作
                    callBack.onSuccess(data);
                }
            });
        }
    }
    public void OnError(final HttpCallBack callBack,final String msg){
        if(callBack!=null){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callBack.onError(msg);
                }
            });
        }
    }

    public static abstract class HttpCallBack{
        //开始
        public void onstart(){};
        //成功回调
        public abstract void onSuccess(String data);
        //失败
        public void onError(String meg){};
    }
}
