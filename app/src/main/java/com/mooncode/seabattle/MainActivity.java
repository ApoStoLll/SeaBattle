package com.mooncode.seabattle;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Controller controller;
    private int width;
    private int height;
    float h;
    GameView.DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        h = (float) (height * 0.82);
        controller = new Controller();
        GameView gameView = new GameView(controller.getPlayer1(), controller.getPlayer2());
        drawView = gameView.new DrawView(this);
        drawView.setOnTouchListener(this);
        setContentView(drawView);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        //Log.d("MYLOG","x: " + x + "y: " + y);
        //Log.d("MYLOG","w: " + width + "h: " + height);
        //Log.d("MYLOG","NewX: " + x*10/width + "NewY: " + y*10/height);
        //Log.d("MYLOG","NewX(int): " + (int)(x*10/width) + "NewY(int): " + (int)(y*10/height));
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                if(controller.getStep() % 2 == 0 && x > width/2)
                    controller.push(new Coordinate(((int)(x*20 / width))-10, (int)(y*10 / h)));
                if(controller.getStep() % 2 != 0 && x < width/2)
                    controller.push(new Coordinate(((int)(x*20 / width)), (int)(y*10 / h)));
                break;
        }
        drawView.postInvalidate();
        return false;
    }
}
