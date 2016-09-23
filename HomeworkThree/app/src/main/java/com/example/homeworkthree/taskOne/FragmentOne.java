package com.example.homeworkthree.taskOne;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.example.homeworkthree.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FragmentOne extends Fragment implements RecyclerViewItemSelector {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> data;
    private List<Bitmap> bitmaps;
    private List<String> titles;
    private List<String> texts;
    private FragmentTwo fragmentTwo;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_one_view_fragment, container, false);
        this.data = new ArrayList<>();
        this.bitmaps = new ArrayList<>();
        this.titles = new ArrayList<>();
        this.texts = new ArrayList<>();
        this.fillDatas();

        this.mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        this.mLayoutManager = new LinearLayoutManager(inflater.getContext());
        this.mAdapter = new CustomAdapter(this.data, this);

        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);


        return view;
    }

    @Override
    public void onItemSelect(int position) {
        this.fragmentTwo = (FragmentTwo) getFragmentManager().findFragmentById(R.id.fragment2);

        this.fragmentTwo.setChanges(this.bitmaps.get(position),this.titles.get(position),this.texts.get(position));
    }

    private void fillDatas() {

        for (int i = 0; i < 11; i++) {
            this.data.add(i + " news");
        }


        this.bitmaps.add(BitmapFactory.decodeResource(this.getResources(),R.drawable.news_0));
        this.bitmaps.add(BitmapFactory.decodeResource(this.getResources(),R.drawable.news_1));
        this.bitmaps.add(BitmapFactory.decodeResource(this.getResources(),R.drawable.news_2));
        this.bitmaps.add(BitmapFactory.decodeResource(this.getResources(),R.drawable.news_3));
        this.bitmaps.add(BitmapFactory.decodeResource(this.getResources(),R.drawable.news_4));
        this.bitmaps.add(BitmapFactory.decodeResource(this.getResources(),R.drawable.news_5));
        this.bitmaps.add(BitmapFactory.decodeResource(this.getResources(),R.drawable.news_6));
        this.bitmaps.add(BitmapFactory.decodeResource(this.getResources(),R.drawable.news_7));
        this.bitmaps.add(BitmapFactory.decodeResource(this.getResources(),R.drawable.news_8));
        this.bitmaps.add(BitmapFactory.decodeResource(this.getResources(),R.drawable.news_9));
        this.bitmaps.add(BitmapFactory.decodeResource(this.getResources(),R.drawable.news_10));

        for (int i = 0; i < 11; i++) {
            this.titles.add("news " + i);
        }


        for (int i = 0; i < 11; i++) {
            this.texts.add(i + " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer orci lacus, tincidunt sit amet mollis eu, tempus ac dolor. Nunc hendrerit euismod euismod.\n"
            + (i + 1) + " Sed consectetur felis nec urna porttitor, sit amet semper arcu pretium. Pellentesque sit amet lectus mollis lectus auctor suscipit eu a enim. Nulla sollicitudin velit id ante finibus, nec scelerisque augue posuere. ");
        }
    }
}
