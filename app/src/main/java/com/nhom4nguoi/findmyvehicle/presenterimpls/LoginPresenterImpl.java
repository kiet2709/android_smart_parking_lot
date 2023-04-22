package com.nhom4nguoi.findmyvehicle.presenterimpls;

import android.util.Log;

import com.nhom4nguoi.findmyvehicle.api.ApiService;
import com.nhom4nguoi.findmyvehicle.models.User;
import com.nhom4nguoi.findmyvehicle.presenters.LoginPresenter;
import com.nhom4nguoi.findmyvehicle.views.LoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenterImpl implements LoginPresenter {

    LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(User user) {
        ApiService.apiservice.login(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                loginView.onLoginSuccess(response);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("kiet", "onFailure: " + t.getMessage().toString());
                loginView.onLoginFailure();
            }
        });
    }
}
