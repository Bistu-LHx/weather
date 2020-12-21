package com.test.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CollAdapter extends RecyclerView.Adapter<CollAdapter.ViewHolder> {
    private List<City> itemList;
    private Context context;

    public CollAdapter(Context context, List<City> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_city, viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder customViewHolder, int i) {
        City weatherItem = itemList.get(i);


        customViewHolder.tv_title.setText(weatherItem.city_name);
        customViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                    onClickListener.onClick(i);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != itemList ? itemList.size() : 0);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_title;

        public ViewHolder(View view) {
            super(view);
            this.tv_title =  view.findViewById(R.id.tv_title);
        }
    }
    public interface OnClickListener{
        void onClick(int position);
    }
    OnClickListener onClickListener;



    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
