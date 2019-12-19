package com.example.hongligs.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.hongligs.R;
import com.example.hongligs.bean.LableBean;
import java.util.List;
public class LableGridadapter extends BaseAdapter {
    private Context context;
    private List<LableBean.TagsByUidBean> tagsByUid;
    public LableGridadapter(Context context, List<LableBean.TagsByUidBean> tagsByUid) {
        this.context = context;
        this.tagsByUid = tagsByUid;
    }

    @Override
    public int getCount() {
        return tagsByUid.size();
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

            view = View.inflate(context, R.layout.lable_item, null);
            holder.text_lable = view.findViewById(R.id.text_lable);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.text_lable.setText(tagsByUid.get(i).getName());//

        Log.d("ttttttttttttt",tagsByUid.get(i).getName());
        return view;
    }

    class ViewHolder {

        TextView text_lable;
    }
    }

