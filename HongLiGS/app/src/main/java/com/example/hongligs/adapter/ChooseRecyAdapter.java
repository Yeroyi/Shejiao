package com.example.hongligs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hongligs.R;
import com.example.hongligs.bean.Choosebean;

import java.util.List;

public class ChooseRecyAdapter extends RecyclerView.Adapter<ChooseRecyAdapter.ViewHolder> {
    private Context context;
    private List<Choosebean.CtlistBean> ctlist;

    public ChooseRecyAdapter(Context context, List<Choosebean.CtlistBean> ctlist) {
        this.context = context;
        this.ctlist = ctlist;
    }

    @NonNull
    @Override
    public ChooseRecyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chose_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);

//        View mView = LayoutInflater.from(context).inflate(R.layout.chose_item, parent, false);
//        ViewHolder holder = new ViewHolder(mView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseRecyAdapter.ViewHolder holder, final int position) {


        holder.itemView.setTag(position);
        holder.chose_text.setText(ctlist.get(position).getName());
        Glide.with(context).load(ctlist.get(position).getBackground()).into(holder.chose_image);


    }

    @Override
    public int getItemCount() {
        return ctlist == null ? 0 : ctlist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView chose_text;
        ImageView chose_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            chose_image = itemView.findViewById(R.id.chose_image);
            chose_text = itemView.findViewById(R.id.chose_text);
        }


    }



}