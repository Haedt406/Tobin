package com.example.tubin;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

public class GameActivity extends Activity {
    private GameView gameView;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);

//        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.river);
//        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                mediaPlayer.start();
//            }
//        });
//        mediaPlayer = MediaPlayer.create(this.getApplicationContext(), R.raw.background);
//
//        mediaPlayer.start();
        setContentView(gameView);

    }

//    private void attachBaseContext(MediaPlayer mediaPlayer) {
//        mediaPlayer.start();
//    }

    @Override
    protected void onPause() {
        super.onPause();

//        mediaPlayer.stop();
        gameView.pause();
        //goToHS();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
    protected void onExit(){
        super.isDestroyed();
}

//    protected void onClose() {
//this.gameView.clearAnimation();    }

}
