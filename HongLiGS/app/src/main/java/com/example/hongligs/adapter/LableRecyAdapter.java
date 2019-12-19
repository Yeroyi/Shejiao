package com.example.hongligs.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hongligs.R;
import com.example.hongligs.activity.LoginActivity;
import com.example.hongligs.bean.LableBean;

import java.util.List;

public class LableRecyAdapter extends RecyclerView.Adapter<LableRecyAdapter.ViewHolder> {

    private Context context;
    private List<LableBean.TagsByUidBean> tagsByUid;
    private OnItemClickListener mOnItemClick;

    public void setOnItemClick(OnItemClickListener mOnItemClick) {
        this.mOnItemClick = mOnItemClick;
    }

    public LableRecyAdapter(Context context, List<LableBean.TagsByUidBean> tagsByUid) {
        this.context = context;
        this.tagsByUid = tagsByUid;
    }

    @NonNull
    @Override
    public LableRecyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.lable_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final LableRecyAdapter.ViewHolder holder, int position) {

        holder.itemView.setTag(position);
       // holder.chose_text.setText(ctlist.get(position).getName());
       holder.text_label.setText(tagsByUid.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClick != null) {
                    mOnItemClick.onClick(1);

                }
            }


        });


    }

    @Override
    public int getItemCount() {
        return tagsByUid.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_label;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
         text_label = itemView.findViewById(R.id.text_lable);


        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
