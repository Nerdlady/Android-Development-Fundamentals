package com.example.homeworktwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button ticTacToeButton;
    private Button taskTwoButton;
    private Button spotifyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ticTacToeButton = (Button) this.findViewById(R.id.tic_tac_toe);
        this.ticTacToeButton.setOnClickListener(this);
        this.taskTwoButton = (Button) this.findViewById(R.id.taskTwoButton);
        this.taskTwoButton.setOnClickListener(this);
        this.spotifyButton = (Button) this.findViewById(R.id.spotify);
        this.spotifyButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tic_tac_toe){
            Intent ticTacToe = new Intent(this,TicTacToeActivity.class);
            this.startActivity(ticTacToe);
        } else if (v.getId() == R.id.taskTwoButton){
            Intent taskTwo = new Intent(this, TaskTwoActivity.class);
            this.startActivity(taskTwo);
        } else if (v.getId() == R.id.spotify){
            Intent spotify = new Intent(this, SpotifyActivity.class);
            this.startActivity(spotify);
        }
    }
}
