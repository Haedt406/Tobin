package com.example.tubin;

import static android.os.Build.VERSION_CODES.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAd;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class MainActivity extends AppCompatActivity {
    private RewardedAd rewardedAd;
    private final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(this, "ca-app-pub-9716145224890446/4498076842\n",
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        Log.d(TAG, loadAdError.toString());
                        rewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd ad) {
                        rewardedAd = ad;
                        Log.d(TAG, "Ad was loaded.");
                        super.onAdLoaded(savedInstanceState);
                        setContentView(R.layout.activity_main);
                        ImageView backgroundImage = findViewById(R.id.backgroundImage);
                        backgroundImage.setImageResource(R.drawable.mainbackground);
                        Handler handler = new Handler();
                        Button HighScoreButton = findViewById(R.id.HS);
                        Button exit = findViewById(R.id.Exit);
                        Button playGame = findViewById(R.id.Play);
                        HighScoreButton.setOnClickListener(view -> {
                            Intent intent = new Intent(MainActivity.this, HS.class);
                            startActivity(intent);
                        });
                        exit.setOnClickListener(view -> {
                            this.finishAffinity();
                        });
                        playGame.setOnClickListener(view -> {
                            Intent intent = new Intent(MainActivity.this, playgame.class);
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