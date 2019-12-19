package com.example.hongligs.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class LableBean {


    private List<TagsByUidBean> tagsByUid;

    public List<TagsByUidBean> getTagsByUid() {
        return tagsByUid;
    }

    public void setTagsByUid(List<TagsByUidBean> tagsByUid) {
        this.tagsByUid = tagsByUid;
    }

    public static class TagsByUidBean implements Parcelable {
        /**
         * name : 国际
         * id : c16
         */

        private String name;
        private String id;

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
            dest.writeString(this.id);
        }

        public TagsByUidBean() {
        }

        protected TagsByUidBean(Parcel in) {
            this.name = in.readString();
            this.id = in.readString();
        }

        public static final Parcelable.Creator<TagsByUidBean> CREATOR = new Parcelable.Creator<TagsByUidBean>() {
            @Override
            public TagsByUidBean createFromParcel(Parcel source) {
                return new TagsByUidBean(source);
            }

            @Override
            public TagsByUidBean[] newArray(int size) {
                return new TagsByUidBean[size];
            }
        };
    }
}
