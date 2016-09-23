package com.example.homeworkthree.taskOne;


import android.content.ClipData;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.homeworkthree.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<String> data;
    public RecyclerViewItemSelector selector;
    private TextView prevView;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        private int position;



        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.viewStyleText);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    textView.setBackgroundColor(Color.GREEN);
                    if (prevView != null && !prevView.equals(textView)) {
                        prevView.setBackgroundColor(Color.blue(R.color.colorPrimary));
                    }
                    setPrevView(textView);
                    selector.onItemSelect(position);

                }
            });


        }


        public void setPosition(int position) {
            this.position = position;
        }
    }

    public CustomAdapter(List<String> data,RecyclerViewItemSelector selector) {
        this.data = data;
        this.selector = selector;
    }
    public void setPrevView(TextView prevView) {
        this.prevView = prevView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_one_view_style, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder != null) {
            holder.textView.setText(this.data.get(position));
            holder.setPosition(position);

        }
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }
}
