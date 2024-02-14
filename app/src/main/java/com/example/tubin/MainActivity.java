package com.example.tubin;

import static android.app.PendingIntent.getActivity;
import static android.content.DialogInterface.*;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

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
        Button htp = findViewById(R.id.htp);
        HighScoreButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, HS.class);
            startActivity(intent);
        });
        exit.setOnClickListener(view -> {
            this.finishAffinity();
        });
        playGame.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
        });

        Button showPopupButton = findViewById(R.id.htp);

        AlertDialog alertDialog = new AlertDialog.Builder(htp.getContext()).create(); //Read Update
        alertDialog.setTitle("How to Play");
        alertDialog.setMessage("Created by Ben for a 1 credit class 'creating apps in Android Studio using java' ");
        showPopupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showPopup();
            }
        });


//        alertDialog.setButton(DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//               alertDialog.create();
//            }
//        });
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

    private void showPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set the dialog title and message
        builder.setTitle("How to Play and Credits")
                .setMessage("This game is based off of the NES game 'Toobin!', created by Benjamin Haedt for 1 credit Android Studio using Java class");

        // Set positive button and its listener
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Do something when the user clicks the positive button
                dialog.dismiss(); // Close the dialog
            }
        });

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}