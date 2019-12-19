package com.example.hongligs.http;

public class URL {
    //服务器地址
    public static final String HTTP_DOMAIN = "http://192.168.1.107:8081/";
    //登陆
    public static final String REGISTER = HTTP_DOMAIN + "user/login";
    //获取验证码
    public static final String MESSAGE = HTTP_DOMAIN + "user/getSMSCode";
    // 首页Banner
    public static final String BANNER = HTTP_DOMAIN + "base/getBanner";

    // 挑选年代
    public static final String XTime = HTTP_DOMAIN + "dicts/getList" ;

    // 下一步
    public static final String Next = HTTP_DOMAIN + "user/selectGender" ;

    //新用户选择圈
    public static final String NEWCHOOSE= HTTP_DOMAIN + "circledic/getCircleTagList" ;

    //新用户选择圈进入下一个页面
    public static final String NEWNEXT= HTTP_DOMAIN + "usertags/save" ;

    //二次筛选圈子
    public static final String SENDCHIOCED= HTTP_DOMAIN + "circledic/regetTagList" ;

    //动态标签Dynamic tbel
   public static final String DYNAMICLABLE= HTTP_DOMAIN + "usertags/getTagsByUid" ;
   // public static final String DYNAMICLABLE=  "http://t.weather.sojson.com/api/weather/city/101220101" ;
    //http://t.weather.sojson.com/api/weather/city/101220101
    //动态列表
    public static final String ListOF= HTTP_DOMAIN + "dynamic/getListBytags" ;

    // 首页推荐
    public static final String Recommend= HTTP_DOMAIN + "dynamic/getListBytags" ;










}
