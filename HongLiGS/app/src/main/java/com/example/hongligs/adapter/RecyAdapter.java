package com.example.hongligs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hongligs.R;
import com.example.hongligs.fragment.wetherbean;

import java.util.ArrayList;
import java.util.List;


public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
//https://www.wanandroid.com/banner/json

    private Context context;
    List<wetherbean.DataBean.ForecastBean> forecast;

    public RecyAdapter(Context context, List<wetherbean.DataBean.ForecastBean> forecast) {
        this.context = context;
        this.forecast = forecast;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.one_item, parent, false);
        ViewHolder holder=new ViewHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.itemView.setTag(position);
        holder.Tv_text.setText(forecast.get(position).getNotice());
        holder.Tv_title.setText(forecast.get(position).getWeek());

    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }


    class  ViewHolder extends RecyclerView.ViewHolder{

        public TextView Tv_title;
        public TextView Tv_text;
        public ImageView Image_1;

        public ViewHolder(@NonNull View itemView) {
           super(itemView);
           Image_1 =  itemView.findViewById(R.id.Image_1);
            Tv_title = itemView.findViewById(R.id.Tv_title);
            Tv_text =  itemView.findViewById(R.id.Tv_text);

       }
   }
}
