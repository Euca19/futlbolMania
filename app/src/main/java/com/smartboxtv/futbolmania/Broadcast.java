package com.smartboxtv.futbolmania;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;




public class Broadcast {

    private static final String TAG = Broadcast.class.getSimpleName();


    /**
     * Register and unRegister Brodacast request
     * {@link Broadcasts}.
     */


    public static void onRegister(final BroadcastReceiver success, String intent) {
        final LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(PartidoAplication.getContext());
        broadcastManager.registerReceiver(success, new IntentFilter(intent));
    }


    public static void unRegister(final BroadcastReceiver success) {
        final LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(PartidoAplication.getContext());
        broadcastManager.unregisterReceiver(success);
    }


    public static void  getPartidos() {
        try {
            Intent intent = new Intent("GET_ARTIST");



            LocalBroadcastManager.getInstance(PartidoAplication.getContext()).sendBroadcast(intent);

        } catch (Exception e) {
        }

    }



}
