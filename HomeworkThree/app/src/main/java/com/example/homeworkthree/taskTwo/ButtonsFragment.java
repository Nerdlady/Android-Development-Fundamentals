package com.example.homeworkthree.taskTwo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.homeworkthree.R;


public class ButtonsFragment extends Fragment implements OnClickListener {
    private Button londonButton;
    private Button parisButton;
    private Button sofiaButton;

    private OnButtonPress onButtonPress;

    public static interface OnButtonPress{
        void parisButtonPress(Fragment f);
        void londonButtonPress();
        void sofiaButtonPress();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.onButtonPress= (OnButtonPress)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_two_buttons_fragment, container, false);
        this.londonButton = (Button) view.findViewById(R.id.londonButton);
        this.parisButton = (Button) view.findViewById(R.id.parisButton);
        this.sofiaButton = (Button) view.findViewById(R.id.sofiaButton);
        this.parisButton.setOnClickListener(this);
        this.londonButton.setOnClickListener(this);
        this.sofiaButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.parisButton){
            this.onButtonPress.parisButtonPress(this);
        } else if(v.getId() == R.id.londonButton){
            this.onButtonPress.londonButtonPress();
        } else if (v.getId() == R.id.sofiaButton){
            this.onButtonPress.sofiaButtonPress();
        }
    }
}
