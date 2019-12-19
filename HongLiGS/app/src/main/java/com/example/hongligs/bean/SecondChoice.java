package com.example.hongligs.bean;

import java.util.List;

public class SecondChoice {


    private List<TaglistBean> taglist;

    public List<TaglistBean> getTaglist() {
        return taglist;
    }

    public void setTaglist(List<TaglistBean> taglist) {
        this.taglist = taglist;
    }

    public static class TaglistBean {
        /**
         * clist : [{"backgrounda":"http://192.168.1.107:8081/files/circle/1.jpg","cdid":"c1","name":"颜值","pid":"cc1","id":"c1","personnum":56,"state":1},{"backgrounda":"http://192.168.1.107:8081/files/circle/1.jpg","cdid":"c2","name":"声控","pid":"cc1","id":"c10","personnum":1,"state":1},{"backgrounda":"http://192.168.1.107:8081/files/circle/1.jpg","cdid":"c3","name":"时尚","pid":"cc1","id":"c11","personnum":3,"state":1}]
         * pname : 交友扩列
         * pid : cc1
         */

        private String pname;
        private String pid;
        private List<ClistBean> clist;

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public List<ClistBean> getClist() {
            return clist;
        }

        public void setClist(List<ClistBean> clist) {
            this.clist = clist;
        }

        public static class ClistBean {
            /**
             * backgrounda : http://192.168.1.107:8081/files/circle/1.jpg
             * cdid : c1
             * name : 颜值
             * pid : cc1
             * id : c1
             * personnum : 56
             * state : 1
             */

            private String backgrounda;
            private String cdid;
            private String name;
            private String pid;
            private String id;
            private int personnum;
            private int state;

            public String getBackgrounda() {
                return backgrounda;
            }

            public void setBackgrounda(String backgrounda) {
                this.backgrounda = backgrounda;
            }

            public String getCdid() {
                return cdid;
            }

            public void setCdid(String cdid) {
                this.cdid = cdid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getPersonnum() {
                return personnum;
            }

            public void setPersonnum(int personnum) {
                this.personnum = personnum;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }
        }
    }
}
