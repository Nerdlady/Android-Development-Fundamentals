package com.example.homeworkone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TaskOneActivity extends Activity implements View.OnClickListener {
    private int firstButtonTimesCliked;
    private int secondButtonTimesCliked;
    private Button firstButton;
    private Button secondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_one);
        this.firstButton = (Button) this.findViewById(R.id.firstButton);
        this.secondButton = (Button) this.findViewById(R.id.secondButton);
        this.secondButton.setOnClickListener(this);
    }


    public void onFirstButtonClicked(View view) {
        if (view.getId() == R.id.firstButton){
            this.firstButtonTimesCliked++;
            this.firstButton.setText(String.valueOf(this.firstButtonTimesCliked));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.secondButton){
            this.secondButtonTimesCliked++;
            this.secondButton.setText(String.valueOf(this.secondButtonTimesCliked));
        }
    }
}
