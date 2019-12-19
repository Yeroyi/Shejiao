package com.example.hongligs.bean;

import java.util.List;

public class Choosebean {


    private List<CtlistBean> ctlist;

    public List<CtlistBean> getCtlist() {
        return ctlist;
    }

    public void setCtlist(List<CtlistBean> ctlist) {
        this.ctlist = ctlist;
    }

    public static class CtlistBean {
        /**
         * background : http://192.168.1.107:8081/files/circle/1.jpg
         * name : 声控
         * id : c10
         */

        private String background;
        private String name;
        private String id;
        private boolean selectedState;

        public boolean isSelectedState() {
            return selectedState;
        }

        public void setSelectedState(boolean selectedState) {
            this.selectedState = selectedState;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
