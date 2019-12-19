package com.example.hongligs.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hongligs.R;
import com.example.hongligs.bean.SecondChoice;

import java.util.List;

public class SecondListAdapter extends BaseAdapter {

    private List<SecondChoice.TaglistBean> taglist;

    private Context context;

    public SecondListAdapter(List<SecondChoice.TaglistBean> taglist, Context context) {
        this.taglist = taglist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return taglist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();

            view = View.inflate(context, R.layout.secondchoice_item, null);
            viewHolder.textname = view.findViewById(R.id.textname);
            viewHolder.gridviewl = view.findViewById(R.id.gridviewl);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textname.setText(taglist.get(i).getPname());

        List<SecondChoice.TaglistBean.ClistBean> clist = taglist.get(i).getClist();

        Gridadapter gridadapter = new Gridadapter(clist, context);
        viewHolder.gridviewl.setAdapter(gridadapter);
        return view;
    }

    class ViewHolder {
        TextView textname;
        GridView gridviewl;

    }

    // 起个名字adapter


    class Gridadapter extends BaseAdapter {

        private List<SecondChoice.TaglistBean.ClistBean> clist;

        private Context context;

        public Gridadapter(List<SecondChoice.TaglistBean.ClistBean> clist, Context context) {
            this.clist = clist;
            this.context = context;
        }

        @Override
        public int getCount() {
            return clist.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            ViewHolder holder;
            if (view == null) {
                holder = new ViewHolder();

                view = View.inflate(context, R.layout.grid_adapter, null);
                holder.live_linlayout = view.findViewById(R.id.live_linlayout);
                holder.text_name = view.findViewById(R.id.text_name);

                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            holder.text_name.setText(clist.get(i).getName());//
            return view;
        }

        class ViewHolder {

            LinearLayout live_linlayout;
            TextView text_name;
        }
    }
}



