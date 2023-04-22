package com.nhom4nguoi.findmyvehicle.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4nguoi.findmyvehicle.R;
import com.nhom4nguoi.findmyvehicle.models.User;
import com.nhom4nguoi.findmyvehicle.presenterimpls.LoginPresenterImpl;
import com.nhom4nguoi.findmyvehicle.presenters.LoginPresenter;
import com.nhom4nguoi.findmyvehicle.views.LoginView;

import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements LoginView {

    LoginPresenter loginPresenter;
    EditText edtStudentCode, edtPassword;
    ImageButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });
    }

    private void clickLogin() {
        User user = new User(
                edtStudentCode.getText().toString(),
                edtPassword.getText().toString()
        );
        loginPresenter.login(user);
    }

    private void initViews() {
        edtStudentCode = (EditText) findViewById(R.id.edt_student_code);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnLogin = (ImageButton) findViewById(R.id.btn_login);
        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void onLoginSuccess( Response<User> response) {
        if (response != null && response.code() == 200) {
            Log.d("kiet", "onLoginSuccess: " );
            Intent intent = new Intent(LoginActivity.this, FindVehicleActivity.class);
            startActivity(intent);

        } else {
            Toast toast = Toast.makeText(LoginActivity.this,"Đăng nhập thất bại, vui lòng kiểm tra lại MSSV và mật khẩu",Toast.LENGTH_LONG);
            toast.show();
        }

    }

    @Override
    public void onLoginFailure() {
        Log.d("kiet", "onLoginFailure: có lỗi");
        Toast toast = Toast.makeText(LoginActivity.this,"Đăng nhập thất bại, vui lòng kiểm tra lại MSSV và mật khẩu",Toast.LENGTH_LONG);
        toast.show();
    }
}