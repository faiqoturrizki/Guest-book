package com.example.faiq.guest_book.network;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.faiq.guest_book.MainActivity;
import com.example.faiq.guest_book.R;

public class SplashActivity extends AppCompatActivity {
    int waktuloading=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.fade_out,R.anim.fade_in);
                finish();
            }
        },waktuloading);
    }
}


