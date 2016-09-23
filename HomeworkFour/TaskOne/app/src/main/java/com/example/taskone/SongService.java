package com.example.taskone;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;

import java.io.IOException;

public class SongService extends Service {
    private static final int FORWARD_DURATION = 10_000;

    private CustomBinder customBinder;
    private MediaPlayer player;
    private int length;
    private boolean isStopped;

    public class CustomBinder extends Binder {
        public SongService getService() {
            return SongService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.customBinder = new CustomBinder();
        player = new MediaPlayer();
        this.player.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        this.player.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.player = new MediaPlayer();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return customBinder;
    }

    public void playSong(Uri songPath) {
        if (this.player.isPlaying()){
           this.player.stop();
        }

        try {
            this.player.reset();
            this.player.setDataSource(getApplicationContext(), songPath);
            this.player.prepare();
            this.isStopped = false;

            this.player.start();
        } catch (IOException ex) {

        }
    }

    public void pauseMusic() {
        this.player.pause();
        length = player.getCurrentPosition();
    }

    public void playMusic(Song song) {
        if (this.player.isPlaying()) {
            return;
        } else if (this.isStopped) {
            this.playSong(song.getFilePath());
        } else {
            this.player.seekTo(length);
            this.player.start();
        }
    }

    public void stopMusic() {
        this.player.stop();
        this.isStopped = true;
    }

    public void moveForward() {
        if (this.player.isPlaying()) {
            int timeToSet = this.player.getCurrentPosition() + FORWARD_DURATION;
            if (!(timeToSet > this.player.getDuration())) {
                this.player.seekTo(timeToSet);
            }
        }
    }

    public void moveBack() {
        if (this.player.isPlaying()) {
            int timeToSet = this.player.getCurrentPosition() - FORWARD_DURATION;
            if (!(timeToSet < 0)) {
                this.player.seekTo(timeToSet);
            }
        }
    }
}
