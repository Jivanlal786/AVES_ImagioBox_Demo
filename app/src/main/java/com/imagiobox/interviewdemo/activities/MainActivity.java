package com.imagiobox.interviewdemo.activities;

import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.imagiobox.interviewdemo.Api.ApiClient;
import com.imagiobox.interviewdemo.Api.ApiResponse;
import com.imagiobox.interviewdemo.Api.ApiService;
import com.imagiobox.interviewdemo.R;
import com.imagiobox.interviewdemo.adapters.OwnersAdapter;
import com.imagiobox.interviewdemo.model.MyResponse;
import com.imagiobox.interviewdemo.utils.NetworkChangeReceiver;
import com.imagiobox.interviewdemo.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NetworkChangeReceiver.ConnectivityReceiverListener {

    Call<List<MyResponse>> responseCall;
    String clientId = "8634366274bd23efb9b023fb9b2c6502e67f7dd5d6a7962b3b49fbee170940f8";
    String TAG = "JJJJJJJ_MainAct";
    ApiResponse apiResponse;
    OwnersAdapter ownersAdapter;
    NetworkChangeReceiver networkChangeReceiver;
    Snackbar snackbar;
    RecyclerView rv_ownerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiResponse = ApiResponse.getInstance();

        networkChangeReceiver = new NetworkChangeReceiver(this);

        rv_ownerlist = findViewById(R.id.rv_ownerlist);

        snackbar = Snackbar.make(findViewById(R.id.rootLayout), "You are offline", Snackbar.LENGTH_LONG); //Assume "rootLayout" as the root layout of every activity.
        snackbar.setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE);
//        snackbar.setTextColor(Color.RED);

        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        ownersAdapter = new OwnersAdapter(MainActivity.this, (ArrayList<MyResponse>) apiResponse.getMyResponseList());
        rv_ownerlist.setLayoutManager(lm);
        rv_ownerlist.setAdapter(ownersAdapter);

        responseCall = ApiClient.getApiClient().create(ApiService.class).getUserResponse(clientId);

        if (Utils.isOnline(MainActivity.this)) {
            responseCall.enqueue(new Callback<List<MyResponse>>() {
                @Override
                public void onResponse(Call<List<MyResponse>> call, Response<List<MyResponse>> response) {
                    if (response.isSuccessful()) {
                        Log.e(TAG, "onResponse: successfully " + response.body().toString());
                        apiResponse.setMyResponseList(response.body());
                        ownersAdapter.setUserList((ArrayList<MyResponse>) apiResponse.getMyResponseList());
                    } else {
                        Log.e(TAG, "onResponse: failed" + response.message());
                    }
                }

                @Override
                public void onFailure(Call<List<MyResponse>> call, Throwable t) {
                    Log.e(TAG, "onFailure: " + t.getCause());
                }
            });
        } else {
            registerReceiver(networkChangeReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }

    }

    private void showNetworkMessage(Boolean isConnected) {
        if (!isConnected) {
            snackbar.show();
        }
    }

    @Override
    public void onNetworkConnectionChanged() {
        if (Utils.isOnline(MainActivity.this)) {
            showNetworkMessage(true);
            if (apiResponse.getMyResponseList().isEmpty()) {
                responseCall.enqueue(new Callback<List<MyResponse>>() {
                    @Override
                    public void onResponse(Call<List<MyResponse>> call, Response<List<MyResponse>> response) {
                        if (response.isSuccessful()) {
                            Log.e(TAG, "onResponse: successfully " + response.body().toString());
                            apiResponse.setMyResponseList(response.body());
                            ownersAdapter.setUserList((ArrayList<MyResponse>) apiResponse.getMyResponseList());
                        } else {
                            Log.e(TAG, "onResponse: failed" + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<MyResponse>> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getCause());
                    }
                });
            }
        } else {
            showNetworkMessage(false);
        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(networkChangeReceiver);
        super.onDestroy();
    }
}