package com.example.taskone;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class SpotifyActivity extends Activity implements RecyclerViewItemSelector {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Song> data;
    private SongService customService;
    private Intent serviceIntent;
    private ServiceConnection conn;
    private Song curentSong;
    private TextView currentSongitleTextView;
    private TextView currentSongSingerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.spotify);
        this.data = new ArrayList<>();

        this.fillData();

        this.currentSongitleTextView = (TextView) this.findViewById(R.id.titleTextView);
        this.currentSongSingerTextView = (TextView) this.findViewById(R.id.singerTextView);

        this.recyclerView = (RecyclerView) this.findViewById(R.id.spotifyRecyclerView);
        this.layoutManager = new LinearLayoutManager(this);
        this.adapter = new SpotifyAdapter(data, this);

        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(adapter);

        SpotifyDecoration decoration = new SpotifyDecoration(this);
        this.recyclerView.addItemDecoration(decoration);

        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                SongService.CustomBinder binder = (SongService.CustomBinder) service;
                customService = binder.getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
            }
        };


        this.serviceIntent = new Intent(this, SongService.class);
        bindService(serviceIntent, conn, Context.BIND_AUTO_CREATE);
        this.startService(serviceIntent);


    }

    public void pauseButonPress(View view) {
        this.customService.pauseMusic();
    }

    @Override
    public void itemSelected(Song song) {
        this.curentSong = song;
        this.currentSongitleTextView.setText(song.getTitle());
        this.currentSongSingerTextView.setText(song.getSinger());
        this.customService.playSong(song.getFilePath());
    }

    @Override
    protected void onDestroy() {
        this.stopService(serviceIntent);
        unbindService(conn);
        super.onDestroy();

    }


    public void playButtonPress(View view) {
        this.customService.playMusic(curentSong);
    }

    public void stopButtonPress(View view) {
        this.customService.stopMusic();
    }

    public void moveForwardButtonPress(View view) {
        this.customService.moveForward();
    }

    public void moveBackButtonPress(View view) {
        this.customService.moveBack();
    }

    private void fillData() {
        this.data.add(new Song("Shatter me", "Lindsey Stirling", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shatter_me_lindsey_stirling)));
        this.data.add(new Song("In the end", "Linkin Park", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.in_the_end_linkin_park)));
        this.data.add(new Song("International love", "Pitbull", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.international_love_pitbull)));
        this.data.add(new Song("Stronger", "Kelly Clarkson", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.stronger_kelly_clarkson)));
        this.data.add(new Song("Veno Neveno", "Dia", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.veno_neveno_dia)));
        this.data.add(new Song("Glad You Came", "The Wanted", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.glad_you_came_the_wanted)));
        this.data.add(new Song("Dead man walking", "Smiley", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.dead_man_walking_smiley)));
        this.data.add(new Song("Turn Me On", "David Guetta ft. Nicki Minaj", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.turn_me_on_david_guetta)));
        this.data.add(new Song("Titanium", "David Guetta", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.titanium_david_guetta)));
        this.data.add(new Song("Love Comes Again", "Tiësto", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.love_comes_again_tiesto)));
    }
}
