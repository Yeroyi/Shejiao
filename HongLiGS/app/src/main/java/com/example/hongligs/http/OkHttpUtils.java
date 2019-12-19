package com.example.hongligs.http;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.hongligs.app.App;
import com.example.hongligs.utils.SPManager;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Time:  2019/11/15
 * 创建者:  @hongwei
 * 邮  箱:  jhw505501898@163.com
 * 描  述:  okhttp 请求
 */
public class OkHttpUtils {

    //对象的属性就相当于类中的变量,对象具有的功能就相当于类中的方法
    private static OkHttpUtils okHttpUtils;

    private static Context mContext;
    //超时时间
    public static final int TIMEOUT = 1000 * 60;

    private OkHttpClient client;


    //json请求
    public static final MediaType JSON = MediaType
            .parse("application/json; charset=utf-8");
    private JSONObject allJson;


    public static OkHttpUtils getInstance(Activity context) {
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {

                okHttpUtils = new OkHttpUtils();


                mContext = context;

            }
        }
        return okHttpUtils;
    }

    public OkHttpUtils() {
        setIntercept();
    }

    //get请求网络
    public void getDataFromNet(String url, String type, final NetCallBack netCallBack) {

        //先判断是否有网络
        if (!NetUtil.isConnected(mContext)) {
            Toast.makeText(mContext, "请检查网络", Toast.LENGTH_SHORT).show();
            Request request = new Request.Builder().url(url).build();
            returnResult(netCallBack, request, type);
        } else {
            Request request = new Request.Builder().url(url).build();
            returnResult(netCallBack, request, type);
        }
    }


    /**
     * post请求  map是body
     *
     * @param url
     * @param map
     * @param
     */
    public void postMap(String url, Map<String, String> map, final NetCallBack callBacks, String type) {


        FormBody.Builder builder = new FormBody.Builder();

        //遍历map

        map.put("uid", SPManager.getUid(mContext));
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.add(entry.getKey(), entry.getValue().toString());
            }
        }

        RequestBody body = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body).build();

        String method = request.method();
        if ("POST".equals(method)) {
            StringBuilder sb = new StringBuilder();
            if (request.body() instanceof FormBody) {
                FormBody body1 = (FormBody) body;
                for (int i = 0; i < body1.size(); i++) {
                    sb.append(body1.encodedName(i) + "=" + body1.encodedValue(i) + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
                //    Log.d(TAG, "| RequestParams:{" + sb.toString() + "}");
                String s = sb.toString();
                String newPost = s.replace(",", "&");
                String newUrl = url.replace("?", "&");
                Log.d("post路径-----", newUrl + "?" + newPost);
            }

        }


        returnResult(callBacks, request, type);

    }


    /**
     * 统一返回结果
     *
     * @param netCallBack
     * @param request
     */
    private void returnResult(final NetCallBack netCallBack, Request request, final String type) {

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                Toast.makeText(MyApplication.context, "请检查网络连接", Toast.LENGTH_SHORT).show();
//                Logger.d("网络请求失败");
            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String result = response.body().string();
                Log.d("Http","网络请求的数据为===" + result);

           //必须指定一个类ACTIVIRY
                App.baseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        netCallBack.onResponse(result, type);


                    }
                });


            }

        });
    }

    /**
     * @param url        上传文件地址
     * @param path       文件路径
     * @param params     上传参数
     * @param fileType   文件类型 一般是file
     * @param MEDIA_TYPE MediaType
     * @param callbacks  通过接口返回结果
     */
    public void upload(String url, String path, Map<String, String> params, String fileType, MediaType MEDIA_TYPE, final NetCallBack callbacks) {
        File file = new File(path);
        MultipartBody.Builder multiRequestBody = new MultipartBody.Builder();

        if (params != null && params.size() > 0) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                multiRequestBody.setType(MultipartBody.FORM)
                        .addFormDataPart(key, value); // 提交普通字段
            }
        }

        // 上传文件使用MultipartBody.Builder
        RequestBody requestBody = multiRequestBody
                .setType(MultipartBody.FORM)
                .addFormDataPart("files", file.getName(), RequestBody.create(MEDIA_TYPE, file)) // 提交图片，第一个参数是键（name="第一个参数"），第二个参数是文件名，第三个是一个RequestBody
                .build();
        // POST请求
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();


        returnResult(callbacks, request, "");
    }


/////////////////////////////////////////拦截器

    private static final int NO_NET_MAX = 60 * 60 * 24 * 7; //7天 无网超时时间
    private static final int NET_MAX = 30; //30秒  有网超时时间

    public void setIntercept() {

        //设置一个缓存地址
        File mFile = new File("data/data");//设置储存目录
        long maxSize = 10 * 1024 * 1024;//10MB最大缓存
        Cache mCache = new Cache(mFile, maxSize);
        //还可以在这里添加okhttp的log拦截器
//        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        client = new OkHttpClient.Builder()
                .addInterceptor(new NoNetInterceptor())    //将无网络拦截器当做应用拦截器添加
                .addNetworkInterceptor(new NetInterceptor()) //将有网络拦截器当做网络拦截器添加
                .connectTimeout(20, TimeUnit.SECONDS) //连接超时
                .writeTimeout(20, TimeUnit.SECONDS)   //写入超时
                .readTimeout(20, TimeUnit.SECONDS)  //读取超时
                .cache(mCache)
                .build();
    }

    /**
     * author: zh on 2017/4/13.
     * 在没有网络的情况下，取读缓存数据
     */

    public class NoNetInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            boolean connected = NetUtil.isConnected(mContext);
            //如果没有网络，则启用 FORCE_CACHE
            if (!connected) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                Response response = chain.proceed(request);
                return response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=3600")
                        .header("versionNumber", "--------=")
                        .removeHeader("Pragma")
                        .build();
            }
            //有网络的时候，这个拦截器不做处理，直接返回
            return chain.proceed(request);
        }
    }

    /**
     * 在有网络的情况下，先去读缓存，设置的缓存时间到了，在去网络获取
     */

    public class NetInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            boolean connected = NetUtil.isConnected(mContext);
            if (connected) {
                //如果有网络，缓存90s
                Response response = chain.proceed(request);
                int maxTime = 600;
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxTime)
                        .build();
            }
            //如果没有网络，不做处理，直接返回
            return chain.proceed(request);
        }
    }
}