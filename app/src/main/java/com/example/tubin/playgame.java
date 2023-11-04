//package com.example.tubin;
//
//import static android.provider.SyncStateContract.Helpers.update;
//
//import android.app.Activity;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//import android.view.View;
//import android.widget.Button;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Rect;
//import android.view.MotionEvent;
//import android.view.View;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class playgame extends Activity implements Runnable {
//    //
//    private Button pauseButton;
//    private Button endGameButton;
//    private Thread gameThread;
//    private SurfaceHolder surfaceHolder;
//    private boolean isPlaying;
//    private Bitmap background;
//    private int bgX = 0;  // Initial X-coordinate of the background
//
//    @Override
//    public void run() {
//
//    }
//
//    public class GameView extends View implements Runnable (Context context {
//        public GameView(Context context) {
//            super(context);
//
//            @Override
//            public void run() {
//                while (isPlaying) {
//                    update();
//                    draw();
//                    control();
//                }
//            }
//
//            void update() {
//                // Update game logic here
//                // For the moving background, you can adjust the bgX value to scroll the background
//                bgX -= 5;  // Adjust the speed as needed
//            }
//
//            void draw() {
//                if (surfaceHolder.getSurface().isValid()) {
//                    Canvas canvas = surfaceHolder.lockCanvas();
//                    // Draw the background at the new position (bgX)
//                    canvas.drawBitmap(background, bgX, 0, null);
//                    surfaceHolder.unlockCanvasAndPost(canvas);
//                }
//            }
//
//            private void control() {
//                try {
//                    Thread.sleep(17);  // Limit the frame rate (approximately 60 FPS)
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            public void pause() {
//                isPlaying = false;
//                try {
//                    gameThread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            public void resume() {
//                isPlaying = true;
//                gameThread = new Thread(this);
//                gameThread.start();
//            }
//        }
//
//        @Override
//        public void run() {
//
//        }
//    }
//    }){
//        super(context);
//        surfaceHolder = getHolder();
//        background = BitmapFactory.decodeResource(getResources(), R.drawable.background);  // Load your background image
//    }
//
//    public playgame(Context context) {
//        super(context);
//    }
//
//    @Override
//    public void run() {
//        while (isPlaying) {
//            update();
//            draw();
//            control();
//        }
//    }
//
//    void update() {
//        // Update game logic here
//        // For the moving background, you can adjust the bgX value to scroll the background
//        bgX -= 5;  // Adjust the speed as needed
//    }
//
//    void draw() {
//        if (surfaceHolder.getSurface().isValid()) {
//            Canvas canvas = surfaceHolder.lockCanvas();
//            // Draw the background at the new position (bgX)
//            canvas.drawBitmap(background, bgX, 0, null);
//            surfaceHolder.unlockCanvasAndPost(canvas);
//        }
//    }
//
//    private void control() {
//        try {
//            Thread.sleep(17);  // Limit the frame rate (approximately 60 FPS)
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void pause() {
//        isPlaying = false;
//        try {
//            gameThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void resume() {
//        isPlaying = true;
//        gameThread = new Thread(this);
//        gameThread.start();
//    }
//}
////    ScrollView scrollView = findViewById(R.id.scrollView); // Replace with your ScrollView ID
////    int scrollTo = 500; // Y position to which you want to scroll
////scrollView.post(() -> scrollView.scrollTo(0, scrollTo));
//
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////
////        gameView = findViewById(R.id.gameView);
////        pauseButton = findViewById(R.id.pauseButton);
////        endGameButton = findViewById(R.id.endGameButton);
////        BackgroundImage backgroundImage;
////        Path path;
////        Player player;
////        PlayerDead playerDead;
////        Random random;
////        int score;
////        Paint scorePaint;
////        int pFrame, pJFrame, pDFrame;
////        static int gameState;
////        ArrayList<Obstacles> obstaclesList;
////        Obstacles obstacles;
////        Obstacles obstacles1;
////        Obstacles obstacles2;
////        Obstacles obstacles3;
////        Obstacles obstacles4;
////        Obstacles obstacles5;
////        Bitmap obs;
////        boolean obsSpawned;
////        int points;
////        final int TEXT_SIZE = 80;
////        boolean collision = false;
////        MediaPlayer hit;
////        boolean hitSound;
////
////            backgroundImage = new BackgroundImage();
////            path = new Path();
////            player = new Player();
////            playerDead = new PlayerDead();
////            // 0 = Not started
////            // 1 = Playing
////            // 2 = GameOver
////            gameState = 0;
////            obsSpawned = false;
////            pFrame = 0;
////            pJFrame = 0;
////            pDFrame = 0;
////            random = new Random();
////            score = 0;
////            scorePaint = new Paint();
////            scorePaint.setColor(Color.RED);
////            scorePaint.setTextSize(TEXT_SIZE);
////            scorePaint.setTextAlign(Paint.Align.LEFT);
////            obstaclesList = new ArrayList<>();
////            obstacles = new Obstacles("");
////            obstacles1 = new Obstacles("Box");
////            obstacles2 = new Obstacles("Crystal");
////            obstacles3 = new Obstacles("IceBox");
////            obstacles4 = new Obstacles("Snowman");
////            obstacles5 = new Obstacles("Stone");
////            obstaclesList.add(obstacles1);
////            obstaclesList.add(obstacles2);
////            obstaclesList.add(obstacles3);
////            obstaclesList.add(obstacles4);
////            obstaclesList.add(obstacles5);
////            points = 0;
////            hitSound = false;
////            hit = MediaPlayer.create(AppConstants.gameActivityContext, R.raw.hit);
////        }
////
////        public void updateAndDrawBackgroundImage (Canvas canvas){
////            if (collision == false) {
////                backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
////                if (backgroundImage.getX() < -AppConstants.getBitmapBank().getBackgroundWidth()) {
////                    backgroundImage.setX(0);
////                }
////            }
////            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);
////            if (backgroundImage.getX() < -(AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)) {
////                canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX() +
////                        AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getY(), null);
////            }
////        }
////
////        public void updateAndDrawPath (Canvas canvas){
////            if (collision == false) {
////                path.setPathX(path.getPathX() - path.getPathVelocity());
////                if (path.getPathX() < -AppConstants.getBitmapBank().getPathWidth()) {
////                    path.setPathX(0);
////                }
////            }
////            canvas.drawBitmap(AppConstants.getBitmapBank().getPath(), path.getPathX(), path.getPathY(), null);
////            if (path.getPathX() < -(AppConstants.getBitmapBank().getPathWidth() - AppConstants.SCREEN_WIDTH)) {
////                canvas.drawBitmap(AppConstants.getBitmapBank().getPath(), path.getPathX() +
////                        AppConstants.getBitmapBank().getPathWidth(), path.getPathY(), null);
////            }
////        }
////
////        public void updateAndDrawPlayer (Canvas canvas){
////            if (gameState == 1) {
////                if (collision == false && AppConstants.playerGrounded == false) {
////                    player.setVelocity(player.getVelocity() + AppConstants.gravity);
////                    player.setY(player.getY() + player.getVelocity());
////                    canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerJump(pJFrame), player.getX(), player.getY(), null);
////                    pJFrame++;
////                    if (pJFrame > 15) {
////                        pJFrame = 0;
////                    }
////                    if (player.getY() >= player.pYInitial) {
////                        player.setY(player.pYInitial);
////                        AppConstants.playerGrounded = true;
////                    }
////                } else if (collision == true && AppConstants.playerGrounded == false) {
////                    playerDead.setVelocity(playerDead.getVelocity() + AppConstants.gravity);
////                    playerDead.setY(playerDead.getY() + playerDead.getVelocity());
////                    canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerDead(pDFrame), playerDead.getX(), playerDead.getY(), null);
////                    pDFrame++;
////                    if (pDFrame == 17) {
////                        gameState = 2;
////                        Context context = AppConstants.gameActivityContext;
////                        Intent intent = new Intent(context, GameOver.class);
////                        intent.putExtra("points", points);
////                        context.startActivity(intent);
////                        ((Activity) context).finish();
////                    }
////                    if (playerDead.getY() >= playerDead.pYInitial) {
////                        playerDead.setY(playerDead.pYInitial);
////                        AppConstants.playerGrounded = true;
////                    }
////                    if (hitSound == false) {
////                        hit.start();
////                        hitSound = true;
////                    }
////                } else if (collision == false && AppConstants.playerGrounded) {
////                    canvas.drawBitmap(AppConstants.getBitmapBank().getPlayer(pFrame), player.getX(), player.getY(), null);
////                    pFrame++;
////                    if (pFrame > 10) {
////                        pFrame = 0;
////                    }
////                } else if (collision == true && AppConstants.playerGrounded) {
////                    canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerDead(pDFrame), playerDead.getX(), playerDead.getY(), null);
////                    pDFrame++;
////                    if (pDFrame == 16) {
////                        gameState = 2;
////                        Context context = AppConstants.gameActivityContext;
////                        Intent intent = new Intent(context, GameOver.class);
////                        intent.putExtra("points", points);
////                        context.startActivity(intent);
////                        ((Activity) context).finish();
////                    }
////                    if (hitSound == false) {
////                        hit.start();
////                        hitSound = true;
////                    }
////                }
////                if (obstacles.cX <= player.pX + AppConstants.getBitmapBank().getPlayerWidth()
////                        && obstacles.cX + obstacles.width >= player.pX
////                        && obstacles.cY >= player.pY
////                        && obstacles.cY <= player.pY + AppConstants.getBitmapBank().getPlayerHeight()) {
////                    collision = true;
////                    obstacles.reset();
////                }
////                canvas.drawText("Pt: " + points, 0, TEXT_SIZE, scorePaint);
////            }
////        }
////
////        public void updateAndDrawObstacles (Canvas canvas){
////            if (gameState == 1) {
////                if (obsSpawned == false) {
////                    int randIndex = random.nextInt(5);
////                    obstacles = obstaclesList.get(randIndex);
////                    obsSpawned = true;
////                }
////                if (collision == false) {
////                    obstacles.cX -= obstacles.velocity;
////                    if (obstacles.type.equalsIgnoreCase("Box")) {
////                        obs = AppConstants.getBitmapBank().getBox();
////                    }
////                    if (obstacles.type.equalsIgnoreCase("Crystal")) {
////                        obs = AppConstants.getBitmapBank().getCrystal();
////                    }
////                    if (obstacles.type.equalsIgnoreCase("IceBox")) {
////                        obs = AppConstants.getBitmapBank().getIceBox();
////                    }
////                    if (obstacles.type.equalsIgnoreCase("Snowman")) {
////                        obs = AppConstants.getBitmapBank().getSnowman();
////                    }
////                    if (obstacles.type.equalsIgnoreCase("Stone")) {
////                        obs = AppConstants.getBitmapBank().getStone();
////                    }
////                    canvas.drawBitmap(obs, obstacles.cX, obstacles.cY, null);
////                    if (obstacles.cX <= -AppConstants.getBitmapBank().getBoxWidth()) {
////                        obstacles.reset();
////                        points++;
////                        obsSpawned = false;
////                    }
////                }
////            }
////        }
////
////        public void tapToStart (Canvas canvas){
////            if (AppConstants.getGameEngine().gameState == 0) {
////                canvas.drawBitmap(AppConstants.getBitmapBank().getTapToStart(), AppConstants.SCREEN_WIDTH / 2 - AppConstants.getBitmapBank().getTapToStartWidth() / 2, AppConstants.SCREEN_HEIGHT / 2 - AppConstants.getBitmapBank().getTapToStartHeight() / 2, null);
////            }
////        }
////        BackgroundImage backgroundImage;
////        Path path;
////        Player player;
////        PlayerDead playerDead;
////        Random random;
////        int score;
////        Paint scorePaint;
////        int pFrame, pJFrame, pDFrame;
////        static int gameState;
////        ArrayList<Obstacles> obstaclesList;
////        Obstacles obstacles;
////        Obstacles obstacles1;
////        Obstacles obstacles2;
////        Obstacles obstacles3;
////        Obstacles obstacles4;
////        Obstacles obstacles5;
////        Bitmap obs;
////        boolean obsSpawned;
////        int points;
////        final int TEXT_SIZE = 80;
////        boolean collision = false;
////        MediaPlayer hit;
////        boolean hitSound;
////
////    public GameEngine() {
////            backgroundImage = new BackgroundImage();
////            path = new Path();
////            player = new Player();
////            playerDead = new PlayerDead();
////            // 0 = Not started
////            // 1 = Playing
////            // 2 = GameOver
////            gameState = 0;
////            obsSpawned = false;
////            pFrame = 0;
////            pJFrame = 0;
////            pDFrame = 0;
////            random = new Random();
////            score = 0;
////            scorePaint = new Paint();
////            scorePaint.setColor(Color.RED);
////            scorePaint.setTextSize(TEXT_SIZE);
////            scorePaint.setTextAlign(Paint.Align.LEFT);
////            obstaclesList = new ArrayList<>();
////            obstacles = new Obstacles("");
////            obstacles1 = new Obstacles("Box");
////            obstacles2 = new Obstacles("Crystal");
////            obstacles3 = new Obstacles("IceBox");
////            obstacles4 = new Obstacles("Snowman");
////            obstacles5 = new Obstacles("Stone");
////            obstaclesList.add(obstacles1);
////            obstaclesList.add(obstacles2);
////            obstaclesList.add(obstacles3);
////            obstaclesList.add(obstacles4);
////            obstaclesList.add(obstacles5);
////            points = 0;
////            hitSound = false;
////            hit = MediaPlayer.create(AppConstants.gameActivityContext, R.raw.hit);
////        }
////
////        public void updateAndDrawBackgroundImage (Canvas canvas){
////            if (collision == false) {
////                backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
////                if (backgroundImage.getX() < -AppConstants.getBitmapBank().getBackgroundWidth()) {
////                    backgroundImage.setX(0);
////                }
////            }
////            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);
////            if (backgroundImage.getX() < -(AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)) {
////                canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX() +
////                        AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getY(), null);
////            }
////        }
////
////        public void updateAndDrawPath (Canvas canvas){
////            if (collision == false) {
////                path.setPathX(path.getPathX() - path.getPathVelocity());
////                if (path.getPathX() < -AppConstants.getBitmapBank().getPathWidth()) {
////                    path.setPathX(0);
////                }
////            }
////            canvas.drawBitmap(AppConstants.getBitmapBank().getPath(), path.getPathX(), path.getPathY(), null);
////            if (path.getPathX() < -(AppConstants.getBitmapBank().getPathWidth() - AppConstants.SCREEN_WIDTH)) {
////                canvas.drawBitmap(AppConstants.getBitmapBank().getPath(), path.getPathX() +
////                        AppConstants.getBitmapBank().getPathWidth(), path.getPathY(), null);
////            }
////        }
////
////        public void updateAndDrawPlayer (Canvas canvas){
////            if (gameState == 1) {
////                if (collision == false && AppConstants.playerGrounded == false) {
////                    player.setVelocity(player.getVelocity() + AppConstants.gravity);
////                    player.setY(player.getY() + player.getVelocity());
////                    canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerJump(pJFrame), player.getX(), player.getY(), null);
////                    pJFrame++;
////                    if (pJFrame > 15) {
////                        pJFrame = 0;
////                    }
////                    if (player.getY() >= player.pYInitial) {
////                        player.setY(player.pYInitial);
////                        AppConstants.playerGrounded = true;
////                    }
////                } else if (collision == true && AppConstants.playerGrounded == false) {
////                    playerDead.setVelocity(playerDead.getVelocity() + AppConstants.gravity);
////                    playerDead.setY(playerDead.getY() + playerDead.getVelocity());
////                    canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerDead(pDFrame), playerDead.getX(), playerDead.getY(), null);
////                    pDFrame++;
////                    if (pDFrame == 17) {
////                        gameState = 2;
////                        Context context = AppConstants.gameActivityContext;
////                        Intent intent = new Intent(context, GameOver.class);
////                        intent.putExtra("points", points);
////                        context.startActivity(intent);
////                        ((Activity) context).finish();
////                    }
////                    if (playerDead.getY() >= playerDead.pYInitial) {
////                        playerDead.setY(playerDead.pYInitial);
////                        AppConstants.playerGrounded = true;
////                    }
////                    if (hitSound == false) {
////                        hit.start();
////                        hitSound = true;
////                    }
////                } else if (collision == false && AppConstants.playerGrounded) {
////                    canvas.drawBitmap(AppConstants.getBitmapBank().getPlayer(pFrame), player.getX(), player.getY(), null);
////                    pFrame++;
////                    if (pFrame > 10) {
////                        pFrame = 0;
////                    }
////                } else if (collision == true && AppConstants.playerGrounded) {
////                    canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerDead(pDFrame), playerDead.getX(), playerDead.getY(), null);
////                    pDFrame++;
////                    if (pDFrame == 16) {
////                        gameState = 2;
////                        Context context = AppConstants.gameActivityContext;
////                        Intent intent = new Intent(context, GameOver.class);
////                        intent.putExtra("points", points);
////                        context.startActivity(intent);
////                        ((Activity) context).finish();
////                    }
////                    if (hitSound == false) {
////                        hit.start();
////                        hitSound = true;
////                    }
////                }
////                if (obstacles.cX <= player.pX + AppConstants.getBitmapBank().getPlayerWidth()
////                        && obstacles.cX + obstacles.width >= player.pX
////                        && obstacles.cY >= player.pY
////                        && obstacles.cY <= player.pY + AppConstants.getBitmapBank().getPlayerHeight()) {
////                    collision = true;
////                    obstacles.reset();
////                }
////                canvas.drawText("Pt: " + points, 0, TEXT_SIZE, scorePaint);
////            }
////        }
////
////        public void updateAndDrawObstacles (Canvas canvas){
////            if (gameState == 1) {
////                if (obsSpawned == false) {
////                    int randIndex = random.nextInt(5);
////                    obstacles = obstaclesList.get(randIndex);
////                    obsSpawned = true;
////                }
////                if (collision == false) {
////                    obstacles.cX -= obstacles.velocity;
////                    if (obstacles.type.equalsIgnoreCase("Box")) {
////                        obs = AppConstants.getBitmapBank().getBox();
////                    }
////                    if (obstacles.type.equalsIgnoreCase("Crystal")) {
////                        obs = AppConstants.getBitmapBank().getCrystal();
////                    }
////                    if (obstacles.type.equalsIgnoreCase("IceBox")) {
////                        obs = AppConstants.getBitmapBank().getIceBox();
////                    }
////                    if (obstacles.type.equalsIgnoreCase("Snowman")) {
////                        obs = AppConstants.getBitmapBank().getSnowman();
////                    }
////                    if (obstacles.type.equalsIgnoreCase("Stone")) {
////                        obs = AppConstants.getBitmapBank().getStone();
////                    }
////                    canvas.drawBitmap(obs, obstacles.cX, obstacles.cY, null);
////                    if (obstacles.cX <= -AppConstants.getBitmapBank().getBoxWidth()) {
////                        obstacles.reset();
////                        points++;
////                        obsSpawned = false;
////                    }
////                }
////            }
////        }
////
////        public void tapToStart (Canvas canvas){
////            if (AppConstants.getGameEngine().gameState == 0) {
////                canvas.drawBitmap(AppConstants.getBitmapBank().getTapToStart(), AppConstants.SCREEN_WIDTH / 2 - AppConstants.getBitmapBank().getTapToStartWidth() / 2, AppConstants.SCREEN_HEIGHT / 2 - AppConstants.getBitmapBank().getTapToStartHeight() / 2, null);
////            }
////        }
////    public class Obstacles {
////        public int cX, cY;
////        public String type;
////        public int velocity;
////        public int width;
////        Random random;
////        public Obstacles(String type) {
////            this.type = type;
////            cX = AppConstants.SCREEN_WIDTH + 1000;
////            cY = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getPathHeight();
////            random = new Random();
////            if(type.equalsIgnoreCase("Box")){
////                cY -= AppConstants.getBitmapBank().getBoxHeight();
////                this.velocity = AppConstants.VELOCITY_OBSTACLES + 14 + random.nextInt(5);// 14-18
////                width = AppConstants.getBitmapBank().getBoxWidth();
////            }else if(type.equalsIgnoreCase("Crystal")){
////                cY -= AppConstants.getBitmapBank().getCrystalHeight();
////                this.velocity = AppConstants.VELOCITY_OBSTACLES + 12 + random.nextInt(5); // 12-16
////                width = AppConstants.getBitmapBank().getCrystalWidth();
////            }else if(type.equalsIgnoreCase("IceBox")){
////                cY -= AppConstants.getBitmapBank().getIceBoxHeight();
////                this.velocity = AppConstants.VELOCITY_OBSTACLES + 11 + random.nextInt(5); // 11-15
////                width = AppConstants.getBitmapBank().getIceBoxWidth();
////            }else if(type.equalsIgnoreCase("Snowman")){
////                cY -= AppConstants.getBitmapBank().getSnowmanHeight();
////                this.velocity = AppConstants.VELOCITY_OBSTACLES + 10 + random.nextInt(6); // 10-15
////                width = AppConstants.getBitmapBank().getSnowmanWidth();
////            }else if(type.equalsIgnoreCase("Stone")){
////                cY -= AppConstants.getBitmapBank().getStoneHeight();
////                this.velocity = AppConstants.VELOCITY_OBSTACLES + 15 + random.nextInt(11); // 15-25
////                width = AppConstants.getBitmapBank().getStoneWidth();
////            }
////        }
////
////        public void reset(){
////            cX = AppConstants.SCREEN_WIDTH + 300;
////            if(type.equalsIgnoreCase("Box")){
////                this.velocity = AppConstants.VELOCITY_OBSTACLES + 14 + random.nextInt(5);// 14-18
////            }else if(type.equalsIgnoreCase("Crystal")){
////                this.velocity = AppConstants.VELOCITY_OBSTACLES + 12 + random.nextInt(5); // 12-16
////            }else if(type.equalsIgnoreCase("IceBox")){
////                this.velocity = AppConstants.VELOCITY_OBSTACLES + 11 + random.nextInt(5); // 11-15
////            }else if(type.equalsIgnoreCase("Snowman")){
////                this.velocity = AppConstants.VELOCITY_OBSTACLES + 10 + random.nextInt(6); // 10-15
////            }else if(type.equalsIgnoreCase("Stone")){
////                this.velocity = AppConstants.VELOCITY_OBSTACLES + 15 + random.nextInt(11); // 15-25
////            }
////        }
////    }
////    }
////public class Player {
////    public int pX, pY, pYInitial, pFrame, velocity;
////
////    public Player(){
////        pX = AppConstants.SCREEN_WIDTH/3 - AppConstants.getBitmapBank().getPlayerWidth();
////        pYInitial = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getPathHeight()
////                - AppConstants.getBitmapBank().getPlayerHeight();
////        pY = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getPathHeight()
////                - AppConstants.getBitmapBank().getPlayerHeight();
////        pFrame = 0;
////        velocity = 0;
////    }
////
////    // Getter method for velocity
////    public int getVelocity(){
////        return velocity;
////    }
////
////    // Setter method for velocity
////    public void setVelocity(int velocity){
////        this.velocity = velocity;
////    }
////
////    // Getter method for getting X-coordinate of the Player
////    public int getX(){
////        return pX;
////    }
////
////    // Getter method for getting the Y-coordinate of the Player
////    public int getY(){
////        return pY;
////    }
////
////    // Setter method for setting the Y-coordinate
////    public void setY(int pY){
////        this.pY = pY;
////    }
////}
////
////}