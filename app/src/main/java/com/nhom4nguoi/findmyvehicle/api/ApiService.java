package com.nhom4nguoi.findmyvehicle.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nhom4nguoi.findmyvehicle.models.User;
import com.nhom4nguoi.findmyvehicle.models.Vehicle;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiservice = new Retrofit.Builder()
            .baseUrl("http://172.22.224.1:8000/api/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @POST("login")
    Call<User> login(@Body User user);

    @GET("locate/number/{id}")
    Call<Vehicle> findVehicle(@Path("id") Integer id);
}
