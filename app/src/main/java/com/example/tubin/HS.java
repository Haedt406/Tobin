package com.example.tubin;


import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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


        SharedPreferences preferences =  getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        String value = preferences.getString("hs", "0");
        Log.d("hs","hs"+value);
        TextView time = findViewById(R.id.HS);
        time.setText(value);
        closeButton.setOnClickListener(view -> {
            finish();
        });
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

