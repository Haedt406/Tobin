package com.example.tubin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView backgroundImage = findViewById(R.id.backgroundImage);
        backgroundImage.setImageResource(R.drawable.mainbackground);
        Handler handler = new Handler();
        Button HighScoreButton = findViewById(R.id.HS);
        Button exit = findViewById(R.id.Exit);
        Button playGame = findViewById(R.id.GameActivity);


        HighScoreButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, HS.class);
            startActivity(intent);
        });
        exit.setOnClickListener(view -> {
            this.finishAffinity();
        });
        playGame.setOnClickListener(view-> {
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
        });
//        // To save data
//        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString("key", "value");
//        editor.apply();
//
//// To retrieve data
//        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//        String value = preferences.getString("key", "default_value");

//        Runnable adRunnable = new Runnable() {
//            @Override
//            public void run() {
//                // Load and show the banner ad here
//                // Call this runnable every 30 seconds
//                handler.postDelayed(this, 30000); // 30,000 milliseconds = 30 seconds
//            }
//        };

// Start the ad display timer when your activity starts
//        handler.post(adRunnable);

    }
}