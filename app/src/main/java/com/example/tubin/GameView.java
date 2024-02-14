package com.example.tubin;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.SharedPreferences.*;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView; // Use SurfaceView

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameView extends SurfaceView implements Runnable, SurfaceHolder.Callback {

    private boolean isPlaying = true;
    private boolean isPaused = false;








    private Thread gameThread;
    private List<Rect> obstacles;
    private Random random;


    private int screenWidth, screenHeight;
    private Paint paint;
    private Bitmap background;
    private int backgroundY;

    private float characterX;
    boolean gameover = false;
    int score = 0;
    boolean win = false;

    Rect x = new Rect(0,0,100,100);

    // Other variables and methods...
    MediaPlayer mediaPlayer;



    public GameView(Context context) {
        super(context);
        screenWidth = context.getResources().getDisplayMetrics().widthPixels;

        getHolder().addCallback(this); // Add this line
        setFocusable(true);
        screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        screenHeight = context.getResources().getDisplayMetrics().heightPixels;
        paint = new Paint();
        random = new Random();
        characterX = screenWidth / 2;




        // Load the background image
        background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(background, screenWidth, screenHeight, false);
        backgroundY = 0;

        obstacles = new ArrayList<>();
        mediaPlayer = MediaPlayer.create(this.getContext(), R.raw.river1);

//        mediaPlayer = MediaPlayer.create(getContext().getApplicationContext(), R.raw.river);
        mediaPlayer.start();
        // Other initialization code...
    }

    @Override
    public void run() {

        while (isPlaying) {
            update();
            draw();
            sleep();
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Initialize and start the game thread
        if (isPaused) {
            resume(); // Resume the game when the surface is created again
        } else {
            // Initialize the game thread for the first time
            if(startedThread==false) {
                gameThread = new Thread(this);
                gameThread.start();
            }
            startedThread = true;
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // Handle surface changes (if needed)
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // Cleanup and pause the game thread
        isPaused = true;
    }
    private void update() {
        if(gameover==false && win == false)
            score++;
        if(gameover==false && score>=1000){
            win=true;
        }
        if (pressedLeft) {
            // Move character left
            characterX -= 10;
        } else if(pressedRight){
            // Move character right
            characterX += 10;
        }
        // Create new obstacles at random intervals
        if (random.nextInt(100) < 2) {
            int obstacleX = random.nextInt(screenWidth - 200);
            int obstacleY = -100;
            int obstacleWidth = 200;
            int obstacleHeight = 50;
            Rect obstacle = new Rect(obstacleX, obstacleY, obstacleX + obstacleWidth, obstacleY + obstacleHeight);
            obstacles.add(obstacle);
        }

        // Move existing obstacles
        for (Rect obstacle : obstacles) {
            if(gameover || win){
                break;
            }
            obstacle.top += 5;
            obstacle.bottom += 5;

            Rect player = new Rect((int)characterX, (int)(screenHeight - 100), (int)(characterX + 100), screenHeight);
            if(obstacle.intersect(player)){
                 gameover = true;
            }
        }

        // Remove obstacles that are off the screen
        List<Rect> obstaclesToRemove = new ArrayList<>();
        for (Rect obstacle : obstacles) {
            if (obstacle.bottom > screenHeight) {
                obstaclesToRemove.add(obstacle);
            }
        }
        obstacles.removeAll(obstaclesToRemove);
    }


    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();

            // Draw the background
            canvas.drawBitmap(background, 0, backgroundY, null);

            // Draw character
            paint.setColor(Color.GREEN);
            canvas.drawRect(characterX, screenHeight - 100, characterX + 100, screenHeight, paint);

            // Draw obstacles
            for (Rect obstacle : obstacles) {
                paint.setColor(Color.RED);
                canvas.drawRect(obstacle, paint);
            }

            //draw score
            paint.setColor(Color.RED);
            paint.setTextSize(80);
            canvas.drawText("Score: "+score, 50,200, paint);

            if(gameover){
                try {
                    paint.setColor(Color.RED);
                    paint.setTextSize(150);
                    canvas.drawText("Game Over", 30,700, paint);
                    SharedPreferences preferences = getContext().getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("hs", ""+score).commit();
                    editor.apply();
                    mediaPlayer.stop();

                    this.clearAnimation();
                    Intent intent = new Intent(getContext(), HS.class);
                    getContext().startActivity(intent);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            if(win){
                try {
                    paint.setColor(Color.RED);
                    paint.setTextSize(150);
                    canvas.drawText("You Win!", 30,700, paint);
                    SharedPreferences preferences = getContext().getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("hs", ""+score).commit();
                    editor.apply();
                    mediaPlayer.stop();

                    this.clearAnimation();
                    Intent intent = new Intent(getContext(), HS.class);
                    getContext().startActivity(intent);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            canvas.drawRect(x, paint);
            paint.setColor(Color.BLACK);
            paint.setTextSize(150);
            canvas.drawText("x", 10,80, paint);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void sleep() {
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        isPlaying = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
boolean startedThread = false;
    public void resume() {
        isPlaying = true;
        if(startedThread==false) {
            gameThread = new Thread(this);
            gameThread.start();
        }
        startedThread = true;
    }
    boolean pressedLeft = false;
    boolean pressedRight = false;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(event.getX() < 100 && event.getY() < 100){
                    Intent intent2 = new Intent(this.getContext(), MainActivity.class);
                    getContext().startActivity(intent2);
                    mediaPlayer.stop();
                    this.clearAnimation();
                }
                if (event.getX() < screenWidth / 2) {
                    // Move character left
                    pressedLeft= true;
                    pressedRight = false;
                } else {
                    // Move character right
                    pressedRight = true;
                    pressedLeft = false;
                }
                break;

            case MotionEvent.ACTION_UP:
                pressedLeft = false;
                pressedRight = false;
                break;
        }
        return true;
    }


}
