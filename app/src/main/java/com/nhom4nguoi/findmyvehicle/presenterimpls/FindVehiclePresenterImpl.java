package com.nhom4nguoi.findmyvehicle.presenterimpls;

import android.os.AsyncTask;
import android.util.Log;

import com.nhom4nguoi.findmyvehicle.api.ApiService;
import com.nhom4nguoi.findmyvehicle.models.User;
import com.nhom4nguoi.findmyvehicle.models.Vehicle;
import com.nhom4nguoi.findmyvehicle.presenters.FindVehiclePresenter;
import com.nhom4nguoi.findmyvehicle.views.FindVehicleView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindVehiclePresenterImpl implements FindVehiclePresenter {

    FindVehicleView findVehicleView;

    public FindVehiclePresenterImpl(FindVehicleView findVehicleView) {
        this.findVehicleView = findVehicleView;
    }


    @Override
    public void findVehicle(int id) {
        ApiService.apiservice.findVehicle(id).enqueue(new Callback<Vehicle>() {
            @Override
            public void onResponse(Call<Vehicle> call, Response<Vehicle> response) {
                findVehicleView.onFindSuccess(response);
            }

            @Override
            public void onFailure(Call<Vehicle> call, Throwable t) {
                findVehicleView.onFindFailure();
            }
        });
    }


}
