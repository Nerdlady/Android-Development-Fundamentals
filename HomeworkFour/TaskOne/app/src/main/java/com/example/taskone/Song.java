package com.example.taskone;


import android.net.Uri;

public class Song {
    private String title;
    private String singer;
    private Uri filePath;

    public Song(String title, String singer, Uri filePath) {
        this.title = title;
        this.singer = singer;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public Uri getFilePath() {
        return filePath;
    }
}
