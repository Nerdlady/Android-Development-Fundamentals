package com.example.tasktwo;

import java.util.Observable;


public class BroadCastHandler extends Observable {
    private static BroadCastHandler handler;


    public static BroadCastHandler getInstance()
    {
        if(handler == null)
            handler = new BroadCastHandler();

        return handler;
    }

    public void updateValue(Object data)
    {
        synchronized (this)
        {
            setChanged();
            notifyObservers(data);
        }
    }
}
