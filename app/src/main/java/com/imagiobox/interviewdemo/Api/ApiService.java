package com.imagiobox.interviewdemo.Api;

import com.imagiobox.interviewdemo.model.MyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("photos/")
    Call<List<MyResponse>> getUserResponse(@Query("client_id") String client_id);

}
