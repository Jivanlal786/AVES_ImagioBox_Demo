package com.imagiobox.interviewdemo.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NetworkChangeReceiver extends BroadcastReceiver {

    ConnectivityReceiverListener connectivityReceiverListener;

    public NetworkChangeReceiver(ConnectivityReceiverListener connectivityReceiverListener) {
        this.connectivityReceiverListener = connectivityReceiverListener;
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {

        connectivityReceiverListener.onNetworkConnectionChanged();

    }

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged();
    }
}