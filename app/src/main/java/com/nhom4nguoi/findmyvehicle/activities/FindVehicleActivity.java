package com.nhom4nguoi.findmyvehicle.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4nguoi.findmyvehicle.R;
import com.nhom4nguoi.findmyvehicle.models.Vehicle;
import com.nhom4nguoi.findmyvehicle.presenterimpls.FindVehiclePresenterImpl;
import com.nhom4nguoi.findmyvehicle.presenters.FindVehiclePresenter;
import com.nhom4nguoi.findmyvehicle.views.FindVehicleView;

import retrofit2.Response;

public class FindVehicleActivity extends AppCompatActivity implements FindVehicleView {

    FrameLayout frameLayout;
    FindVehiclePresenter findVehiclePresenter;
    EditText edtCardNumber;
    Button btnFind;
    ImageButton imgbtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_vehicle);
        initViews();
        imgbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindVehicleActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findVehicle();
            }
        });
    }

    private void findVehicle() {
        frameLayout.setVisibility(View.VISIBLE);
        findVehiclePresenter.findVehicle(Integer.parseInt(edtCardNumber.getText().toString()));
    }

    private void initViews() {
        imgbtnBack = (ImageButton) findViewById(R.id.back_arrow);
        edtCardNumber = (EditText) findViewById(R.id.edt_card_number);
        btnFind = (Button) findViewById(R.id.btn_find);
        findVehiclePresenter = new FindVehiclePresenterImpl(this);
        frameLayout = (FrameLayout) findViewById(R.id.progressBarHolder);
    }

    @Override
    public void onFindSuccess(Response<Vehicle> response) {

        try {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (response.body() != null){
                        // Do something after 5s = 5000ms
                        Vehicle vehicle = new Vehicle(
                                response.body().getId().toString(),
                                response.body().getImageUrl(),
                                response.body().getLocate(),
                                response.body().getCardNumber()
                        );
                        Intent intent = new Intent(FindVehicleActivity.this, MainActivity.class);
                        intent.putExtra("vehicle", vehicle);
                        intent.putExtra("cardNumber", edtCardNumber.getText().toString());
                        frameLayout.setVisibility(View.GONE);
                        startActivity(intent);
                    } else {
                        Toast.makeText(FindVehicleActivity.this, "Không tìm thấy biển số xe của bạn, vui lòng nhập lại!", Toast.LENGTH_LONG).show();
                        frameLayout.setVisibility(View.GONE);
                        edtCardNumber.setText("");
                    }

                }
            }, 500);
        } catch (Exception ex){


        }



    }

    @Override
    public void onFindFailure() {
        Toast.makeText(FindVehicleActivity.this, "Không tìm thấy biển số xe của bạn, vui lòng nhập lại!", Toast.LENGTH_LONG).show();
    }
}