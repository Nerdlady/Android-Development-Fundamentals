package com.example.homeworkfive;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class InfoActivity extends Activity {
    private DatabaseHelper helper;
    private Adapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.items_layout);
        this.helper = new DatabaseHelper(this);
        this.recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);

        this.adapter = new Adapter(this.helper.getData());

        this.layoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.recyclerView.setAdapter(this.adapter);
    }
}
