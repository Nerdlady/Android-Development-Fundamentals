package com.example.tasktwo;


import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Observable;
import java.util.Observer;

public class BateryChangedService extends Service implements Observer {

    private BateryChangedBinder binder;
    private int oldBateryPercents;
    private int newBateryPercents;
    private CustomReceiver receiver;


    public class BateryChangedBinder extends Binder {
        public BateryChangedService getService() {
            return BateryChangedService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.binder = new BateryChangedBinder();
        BroadCastHandler.getInstance().addObserver(this);
        this.newBateryPercents = -1;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.oldBateryPercents = this.newBateryPercents;
        this.startReceiver();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (oldBateryPercents == -1) {
            oldBateryPercents = (int) arg;
        }
        newBateryPercents = (int) arg;
    }

    public int getPersontsChanged() {
        return Math.abs(this.oldBateryPercents - this.newBateryPercents);
    }

    private void startReceiver() {
        receiver = new CustomReceiver();

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.BATTERY_CHANGED");

        this.registerReceiver(receiver, filter);
    }

    @Override
    public void onDestroy() {
        this.unregisterReceiver(receiver);
        super.onDestroy();
    }
}
