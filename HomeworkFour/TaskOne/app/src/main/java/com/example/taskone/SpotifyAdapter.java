package com.example.taskone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class SpotifyAdapter extends RecyclerView.Adapter<SpotifyAdapter.ViewHolder> {
    private ArrayList<Song> mAdapterData;
    RecyclerViewItemSelector selector;

    public  class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        TextView smallTextView;
        private int position;

        public ViewHolder(final View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.spotifyTextView);
            smallTextView = (TextView) itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selector.itemSelected(mAdapterData.get(position));
                }
            });
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }


    public SpotifyAdapter(ArrayList<Song> data,RecyclerViewItemSelector selector) {
        this.mAdapterData = data;
        this.selector = selector;
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
            Song song = this.mAdapterData.get(position);
            holder.mTextView.setText(song.getTitle());
            holder.smallTextView.setText(song.getSinger());
            holder.setPosition(position);
        }
    }


}
