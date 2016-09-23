package com.example.homeworktwo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class SpotifyAdapter extends RecyclerView.Adapter<SpotifyAdapter.ViewHolder>{
    private ArrayList<String[]> mAdapterData;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        TextView smallTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.spotifyTextView);
            smallTextView = (TextView) itemView.findViewById(R.id.textView3);
        }
    }


    public SpotifyAdapter(ArrayList<String[]> data) {
        this.mAdapterData = data;
    }

    @Override
    public int getItemCount() {
        return this.mAdapterData.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spotidy_recyclerview_teplate, parent, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder != null) {
            holder.mTextView.setText(mAdapterData.get(position)[0]);
            holder.smallTextView.setText(mAdapterData.get(position)[1]);
        }
    }
}
