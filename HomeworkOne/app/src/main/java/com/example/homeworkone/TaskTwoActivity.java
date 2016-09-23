package com.example.homeworkone;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TaskTwoActivity extends Activity implements View.OnClickListener {

    private TextView view;
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;

    private int buttonATimesPress;
    private int buttonBTimesPress;
    private int buttonCTimesPress;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.task_two);
        this.view = (TextView) this.findViewById(R.id.textView);
        this.buttonA = (Button) this.findViewById(R.id.buttonA);
        this.buttonB = (Button) this.findViewById(R.id.buttonB);
        this.buttonC = (Button) this.findViewById(R.id.buttonC);
        this.buttonA.setOnClickListener(this);
        this.buttonB.setOnClickListener(this);
        this.buttonC.setOnClickListener(this);
        this.view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int timesPress=0;
        switch (v.getId()){
            case R.id.buttonA:
                button = this.buttonA;
                this.buttonATimesPress++;
                timesPress = this.buttonATimesPress;
                break;
            case R.id.buttonB:
                button = this.buttonB;
                this.buttonBTimesPress++;
                timesPress = this.buttonBTimesPress;
                break;
            case R.id.buttonC:
                button = this.buttonC;
                this.buttonCTimesPress++;
                timesPress = this.buttonCTimesPress;
                break;
            case R.id.textView:
                Intent newActiviry = new Intent(this,InfoActivity.class);
                newActiviry.putExtra("ID",button.getId());
                newActiviry.putExtra("Text",button.getText());
                this.startActivity(newActiviry);
                return;
            default:
                return;
        }

        if (timesPress >= 2){
            this.view.setText(button.getText());
        } else {
            this.view.setText(String.valueOf(button.getId()));
        }
    }
}
