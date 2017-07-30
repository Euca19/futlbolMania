package com.smartboxtv.futbolmania;

import android.app.Application;
import android.content.Context;



public class PartidoAplication extends Application {

    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();

        PartidoAplication.context = getApplicationContext();
    }

    public static Context getContext() {
        return PartidoAplication.context;
    }



}
