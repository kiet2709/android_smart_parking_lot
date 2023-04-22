package com.nhom4nguoi.findmyvehicle.views;

import com.nhom4nguoi.findmyvehicle.models.User;

import retrofit2.Response;

public interface LoginView {
    public void onLoginSuccess(Response<User> response);
    public void onLoginFailure();
}
