package com.example.homeworkone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class InfoActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        this.textView = (TextView) this.findViewById(R.id.infoText);

        if (getIntent() != null && this.textView != null){
            StringBuilder allInfo = new StringBuilder();
            allInfo.append("ID: ")
                    .append(String.valueOf(this.getIntent().getIntExtra("ID",0)))
                    .append("\nText: ")
                    .append(this.getIntent().getStringExtra("Text"));

            this.textView.setText(String.valueOf(allInfo.toString()));
        }

    }
}
