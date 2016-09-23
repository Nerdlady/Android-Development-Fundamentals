package com.example.homeworktwo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;


public class SpotifyActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String[]> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.spotify);
        this.data = new ArrayList<>();

        this.fillData();

        this.recyclerView = (RecyclerView) this.findViewById(R.id.spotifyRecyclerView);
        this.layoutManager = new LinearLayoutManager(this);
        this.adapter = new SpotifyAdapter(data);

        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(adapter);

        SpotifyDecoration decoration = new SpotifyDecoration(this);
        this.recyclerView.addItemDecoration(decoration);

    }

    private void fillData() {
        String[] firstSong = {"Shatter me","Lindsey Stirling"};
        String[] secondSong = {"In the end","Linkin Park"};
        String[] thirdSong = {"International love","Pitbull"};
        String[] fourthSong = {"Stronger","Kelly Clarkson"};
        String[] fifthSong = {"Rivers and Roads","The Head and the Heart"};
        String[] sixthSong = {"Glad You Came","The Wanted"};
        String[] eightSong = {"Dead man walking","Smiley "};
        String[] nineSong = {"Turn Me On","David Guetta ft. Nicki Minaj"};
        String[] tenSong = {"She Wolf","The Wanted"};
        String[] elevenSong = {"Titanium","David Guetta"};
        String[] twelveSong = {"Love Comes Again","Tiësto"};

        this.data.add(firstSong);
        this.data.add(secondSong);
        this.data.add(thirdSong);
        this.data.add(fourthSong);
        this.data.add(fifthSong);
        this.data.add(sixthSong);
        this.data.add(eightSong);
        this.data.add(nineSong);
        this.data.add(tenSong);
        this.data.add(elevenSong);
        this.data.add(twelveSong);
    }
}
