package com.example.hongligs.bean;

import java.util.List;

public class ListofBean {


    private List<DlistBean> dlist;

    public List<DlistBean> getDlist() {
        return dlist;
    }

    public void setDlist(List<DlistBean> dlist) {
        this.dlist = dlist;
    }

    public static class DlistBean {
        /**
         * firstpic : http://192.168.1.107:8081/files/dynamic/xueshan/xueshan.jpg
         * uname : 且听风铃
         * cl : 0
         * id : e6212381-1030-11ea-b841-00d861a225ad
         * time : 2018-06-05
         * avatar : http://192.168.1.107:8081/files/user/head46.jpg
         * tag : 声控
         * content : 随手记录
         雪山上曾发生的一件事

         */

        private String firstpic;
        private String uname;
        private String cl;
        private String id;
        private String time;
        private String avatar;
        private String tag;
        private String content;

        public String getFirstpic() {
            return firstpic;
        }

        public void setFirstpic(String firstpic) {
            this.firstpic = firstpic;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getCl() {
            return cl;
        }

        public void setCl(String cl) {
            this.cl = cl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
