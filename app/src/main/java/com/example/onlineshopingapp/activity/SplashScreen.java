package com.example.onlineshopingapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.onlineshopingapp.R;
import com.example.onlineshopingapp.databinding.ActivitySplashBinding;
import com.example.onlineshopingapp.login.LoginActivity;

public class SplashScreen extends AppCompatActivity {
    private static final int SPLASH = 3300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // setContentView(R.layout.activity_splash);

        ActivitySplashBinding bindingSplash = DataBindingUtil.setContentView(this, R.layout.activity_splash);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH);

    } }
