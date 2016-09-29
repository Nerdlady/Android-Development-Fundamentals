package com.example.homeworkfive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.helper = new DatabaseHelper(this);
    }

    public void showDataButton(View view) {
        Intent intent = new Intent(this,InfoActivity.class);
        this.startActivity(intent);
    }

    public void addItemsButton(View view) {
      helper.addRandomData();
        Toast.makeText(this,"10 items added",Toast.LENGTH_SHORT).show();
    }
}
