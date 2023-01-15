package com.imagiobox.interviewdemo.Api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.imagiobox.interviewdemo.model.MyResponse;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse {

    List<MyResponse> myResponseList = new ArrayList<>();

    public static ApiResponse apiResponse;

    public static ApiResponse getInstance() {
        if (apiResponse == null) {
            apiResponse = new ApiResponse();
        }
        return apiResponse;
    }

    public List<MyResponse> getMyResponseList() {
        return myResponseList;
    }

    public void setMyResponseList(List<MyResponse> myResponseList) {
        this.myResponseList = myResponseList;
    }
}
