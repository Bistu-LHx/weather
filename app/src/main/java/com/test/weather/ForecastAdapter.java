package com.test.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    private List<Weather.DataDTO.ForecastDTO> itemList;
    private Context context;

    public ForecastAdapter(Context context, List<Weather.DataDTO.ForecastDTO> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_index, null);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder customViewHolder, int i) {
        Weather.DataDTO.ForecastDTO weatherItem = itemList.get(i);


        customViewHolder.tv_title.setText(weatherItem.getYmd());


        customViewHolder.tv_sugg.setText(weatherItem.getHigh());
        customViewHolder.tv_detail.setText( weatherItem.getLow() );
    }

    @Override
    public int getItemCount() {
        return (null != itemList ? itemList.size() : 0);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_title;
        public TextView tv_sugg;
        public TextView tv_detail;

        public ViewHolder(View view) {
            super(view);
            this.tv_title =  view.findViewById(R.id.tv_title);
            this.tv_sugg =  view.findViewById(R.id.tv_sugg);
            this.tv_detail =  view.findViewById(R.id.tv_detail);
        }
    }
}
