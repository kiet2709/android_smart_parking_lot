package com.nhom4nguoi.findmyvehicle.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nhom4nguoi.findmyvehicle.R;
import com.nhom4nguoi.findmyvehicle.models.Vehicle;
import com.nhom4nguoi.findmyvehicle.presenters.FindVehiclePresenter;
import com.nhom4nguoi.findmyvehicle.views.FindVehicleView;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imgLocate;
    InputStream is;
    Bitmap bitmap;
    TextView txtLicensePlate, txtcardNumber, txtLocate;
    ImageButton imgbtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        imgbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FindVehicleActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        Vehicle vehicle = (Vehicle) intent.getSerializableExtra("vehicle");
        String cardNumber = (String) intent.getStringExtra("cardNumber");
        Log.d("kiet", "onCreate: " + vehicle.getImageUrl() + " ======");
        renderData(vehicle, cardNumber);
    }

    private void initViews() {
        txtLicensePlate = (TextView) findViewById(R.id.txt_license_plate);
        txtcardNumber = (TextView) findViewById(R.id.txt_card_number);
        txtLocate = (TextView) findViewById(R.id.txt_locate);
        imgLocate = (ImageView) findViewById(R.id.img_locate);
        imgbtnBack = (ImageButton) findViewById(R.id.back_arrow);
    }

    private void renderData(Vehicle vehicle,String cardNumber) {
        txtLicensePlate.setText(vehicle.getId()+"");
        txtcardNumber.setText(cardNumber);
        txtLocate.setText(vehicle.getLocate());

        Glide.with(this).load(vehicle.getImageUrl()).into(imgLocate);
    }

}