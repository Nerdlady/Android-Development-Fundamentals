package com.example.homeworkthree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.homeworkthree.taskOne.TaskOneActivity;
import com.example.homeworkthree.taskTwo.TaskTwoActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button mTaskOneButton;
    private Button mTaskTwoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mTaskOneButton = (Button) this.findViewById(R.id.taskOneButton);
        this.mTaskTwoButton = (Button) this.findViewById(R.id.taskTwoButton);

        this.mTaskOneButton.setOnClickListener(this);
        this.mTaskTwoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.taskOneButton){
            Intent taskOne = new Intent(this, TaskOneActivity.class);
            this.startActivity(taskOne);
        } else if (v.getId() == R.id.taskTwoButton){
            Intent taskTwo = new Intent(this, TaskTwoActivity.class);
            this.startActivity(taskTwo);
        }
    }
}
