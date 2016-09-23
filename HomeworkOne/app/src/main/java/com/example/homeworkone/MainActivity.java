package com.example.homeworkone;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button taskOneButton;
    private Button taskTwoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.taskOneButton = (Button) this.findViewById(R.id.taskOne);
        this.taskTwoButton = (Button) this.findViewById(R.id.taskTwo);
        this.taskOneButton.setOnClickListener(this);
        this.taskTwoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.taskOne){
            Intent taskOneIntent = new Intent(this,TaskOneActivity.class);
            this.startActivity(taskOneIntent);
        } else if(v.getId() == R.id.taskTwo){
            Intent taskOneIntent = new Intent(this,TaskTwoActivity.class);
            this.startActivity(taskOneIntent);
        }
    }
}
