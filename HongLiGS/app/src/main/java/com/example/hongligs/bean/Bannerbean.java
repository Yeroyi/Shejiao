package com.example.hongligs.bean;

import java.util.List;

public class Bannerbean {


//    private List<BlistBean> blist;
//
//    public List<BlistBean> getBlist() {
//        return blist;
//    }
//
//    public void setBlist(List<BlistBean> blist) {
//        this.blist = blist;
//    }
//
//    public static class BlistBean {
        /**
         * id : ban1
         * state : 1
         * url : http://192.168.1.107:8080/aaju/image/banner/banner1.png
         */

        private String id;
        private int state;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
//    }
}
