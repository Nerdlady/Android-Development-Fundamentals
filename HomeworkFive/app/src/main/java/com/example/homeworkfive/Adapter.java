package com.example.homeworkfive;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Food> mAdapterData;


    public  class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView info;
        TextView id;
        private int position;

        public ViewHolder(final View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.titleTextView);
            info = (TextView) itemView.findViewById(R.id.infoTextView);
            id= (TextView) itemView.findViewById(R.id.idTextView);


        }

        public void setPosition(int position) {
            this.position = position;
        }
    }


    public Adapter(ArrayList<Food> data) {
        this.mAdapterData = data;

    }

    @Override
    public int getItemCount() {
        return this.mAdapterData.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_template, parent, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder != null) {
            Food food = this.mAdapterData.get(position);
            holder.name.setText(food.getName());
            holder.info.setText(food.getDescrioption());
            holder.id.setText(String.valueOf(food.getId()));
            holder.setPosition(position);
        }
    }


}
