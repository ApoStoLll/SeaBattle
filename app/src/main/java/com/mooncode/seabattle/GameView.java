package com.mooncode.seabattle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

public class GameView {
    Player player1;
    Player player2;
    GameView(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }
    class DrawView extends SurfaceView implements SurfaceHolder.Callback {

        private DrawThread drawThread;
        private int width;
        private int height;
        private Paint p;

        public DrawView(Context context) {
            super(context);
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            width = size.x;
            height = size.y;
            getHolder().addCallback(this);
            p = new Paint();
            p.setStrokeWidth(10);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                   int height) {

        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            drawThread = new DrawThread(getHolder());
            drawThread.setRunning(true);
            drawThread.start();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            boolean retry = true;
            drawThread.setRunning(false);
            while (retry) {
                try {
                    drawThread.join();
                    retry = false;
                } catch (InterruptedException e) {
                }
            }
        }

        class DrawThread extends Thread {

            private boolean running = false;
            private SurfaceHolder surfaceHolder;

            DrawThread(SurfaceHolder surfaceHolder) {
                this.surfaceHolder = surfaceHolder;
            }

            void setRunning(boolean running) {
                this.running = running;
            }

            void drawMap(Canvas canvas, int c, int[][] field){
                int w = width/20;//width/2;
                for(int i = 0; i < 10; i++){
                    for(int j = 0; j < 10; j++){
                        if(field[i][j] == -2) { //CLEAR
                            p.setColor(Color.BLACK);
                            p.setStyle(Paint.Style.STROKE);
                        }
                        if(field[i][j] == -1) { //SHOT
                            p.setColor(Color.RED);
                            p.setStyle(Paint.Style.FILL);
                        }
                        canvas.drawRect(i * w + c, j * w, (i+1) * w + c, (j+1) * w, p);
                    }
                }
            }

            @Override
            public void run() {
                Canvas canvas;
                while (running) {
                    canvas = null;
                    try {
                        canvas = surfaceHolder.lockCanvas(null);
                        if (canvas == null)
                            continue;
                        //TUT DRAW
                        //canvas.drawColor(Color.GREEN);
                        drawMap(canvas, 0, player1.getField().getField());
                        drawMap(canvas, width/2, player2.getField().getField());
                        p.setColor(Color.RED);
                        canvas.drawLine(width/2,0,width/2 + 2,height, p);//ОТЕДЛЯЕМ СЕРЕДИНУ

                    } finally {
                        if (canvas != null) {
                            surfaceHolder.unlockCanvasAndPost(canvas);
                        }
                    }
                }
            }
        }

    }
}
