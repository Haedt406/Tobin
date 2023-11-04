package com.example.tubin;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class HS extends MainActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler();
        setContentView(R.layout.highscore);
        ImageButton closeButton = findViewById(R.id.close);
        closeButton.setOnClickListener(view -> {
            finish();
        });

        SharedPreferences preferences = getSharedPreferences("highscore", Context.MODE_PRIVATE);
        String value = preferences.getString("key", "default_value");

        Runnable adRunnable = new Runnable() {
            @Override
            public void run() {
                // Load and show the banner ad here
                // Call this runnable every 30 seconds
                handler.postDelayed(this, 30000); // 30,000 milliseconds = 30 seconds
            }
        };

    }
}

