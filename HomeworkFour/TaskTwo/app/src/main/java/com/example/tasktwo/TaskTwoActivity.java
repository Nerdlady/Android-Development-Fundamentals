package com.example.tasktwo;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;


public class TaskTwoActivity extends AppCompatActivity implements Observer {

    private TextView bateryInfoTextView;
    private BateryChangedService bateryChangedService;

    private Intent serciveIntent;

    private ServiceConnection connection;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.task_two);

        this.bateryInfoTextView = (TextView) this.findViewById(R.id.bataryInfoTextView);
        connection= new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                BateryChangedService.BateryChangedBinder binder = (BateryChangedService.BateryChangedBinder) service;
                bateryChangedService = binder.getService();

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
            }
        };

        BroadCastHandler.getInstance().addObserver(this);
        this.setService();
    }



    private void setService() {
        if (!isMyServiceRunning(BateryChangedService.class)){

            this.serciveIntent = new Intent(this, BateryChangedService.class);
            this.startService(serciveIntent);
            bindService(serciveIntent, connection, Context.BIND_AUTO_CREATE);


            PendingIntent pintent = PendingIntent.getService(this, 0, serciveIntent, 0);

            AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            // Start service every hour
            alarm.setRepeating(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime(),
                    60000, pintent);
        }
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (isMyServiceRunning(BateryChangedService.class) && this.bateryChangedService != null) {
            this.bateryInfoTextView.setText(String.format("Batery changed with %d %%", bateryChangedService.getPersontsChanged()));
        }
    }




}
