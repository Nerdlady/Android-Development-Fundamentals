package com.example.homeworkthree.taskTwo;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.homeworkthree.R;

public class TaskTwoActivity extends AppCompatActivity implements ButtonsFragment.OnButtonPress {
    private ParisFragment parisFragment;
    private LondonFragment londonFragment;
    private SofiaFragment sofiaFragment;

    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.task_two);
        this.parisFragment = new ParisFragment();
        this.fragment = new ButtonsFragment();
        this.londonFragment = new LondonFragment();
        this.sofiaFragment = new SofiaFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }

    @Override
    public void parisButtonPress(Fragment f) {
        final FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.addToBackStack(null);
        ft.replace(R.id.fragmentContainer, parisFragment).commit();

    }

    @Override
    public void londonButtonPress() {
        final FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.addToBackStack(null);
        ft.replace(R.id.fragmentContainer, londonFragment).commit();
    }

    @Override
    public void sofiaButtonPress() {
        final FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.addToBackStack(null);
        ft.replace(R.id.fragmentContainer, sofiaFragment).commit();
    }


}
