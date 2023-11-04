package com.example.tubin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView; // Use SurfaceView
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameView extends SurfaceView implements Runnable, SurfaceHolder.Callback {

    private boolean isPlaying = true;
    private boolean isPaused = false;





    // ... (remaining code)



    private Thread gameThread;
    private List<Rect> obstacles;
    private Random random;

    private int screenWidth, screenHeight;
    private Paint paint;
    private Bitmap background;
    private int backgroundY;

    private float characterX;
    private AdView adView; // AdMob banner ad view
    // Other variables and methods...

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
            gameThread = new Thread(this);
            gameThread.start();
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
        // Create new obstacles at random intervals
        if (random.nextInt(100) < 5) {
            int obstacleX = random.nextInt(screenWidth - 200);
            int obstacleY = -100;
            int obstacleWidth = 200;
            int obstacleHeight = 50;

            Rect obstacle = new Rect(obstacleX, obstacleY, obstacleX + obstacleWidth, obstacleY + obstacleHeight);
            obstacles.add(obstacle);
        }

        // Move existing obstacles
        for (Rect obstacle : obstacles) {
            obstacle.top += 5;
            obstacle.bottom += 5;
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

    public void resume() {
        isPlaying = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() < screenWidth / 2) {
                    // Move character left
                    characterX -= 10;
                } else {
                    // Move character right
                    characterX += 10;
                }
                break;
        }
        return true;
    }


}
