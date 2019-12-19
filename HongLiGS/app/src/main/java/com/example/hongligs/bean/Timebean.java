package com.example.hongligs.bean;

import java.util.List;

public class Timebean {


    private List<DlistBean> dlist;

    public List<DlistBean> getDlist() {
        return dlist;
    }

    public void setDlist(List<DlistBean> dlist) {
        this.dlist = dlist;
    }

    public static class DlistBean {
        /**
         * createTime : 1575009674000
         * id : 19
         * k : 1
         * type : age
         * updateTime : 1576219276000
         * val : 60后
         */

        private long createTime;
        private int id;
        private String k;
        private String type;
        private long updateTime;
        private String val;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getK() {
            return k;
        }

        public void setK(String k) {
            this.k = k;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }
}
