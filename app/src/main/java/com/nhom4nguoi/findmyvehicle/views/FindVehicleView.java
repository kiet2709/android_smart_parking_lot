package com.nhom4nguoi.findmyvehicle.views;

import com.nhom4nguoi.findmyvehicle.models.Vehicle;

import retrofit2.Response;

public interface FindVehicleView {
    public void onFindSuccess(Response<Vehicle> response);
    public void onFindFailure();
}
