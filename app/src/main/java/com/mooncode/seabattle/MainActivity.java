package com.mooncode.seabattle;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Controller controller;
    private int width;
    private int height;
    GameView.DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        controller = new Controller();
        GameView gameView = new GameView(controller.getPlayer1(), controller.getPlayer2());
        drawView = gameView.new DrawView(this);
        setContentView(drawView);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                if((controller.getStep() % 2 == 0 && x > width/2) ||
                        (controller.getStep() % 2 != 0 && x < width/2))
                controller.push(new Coordinate((int)(x / width/10), (int)(y / height/10)));
                break;
        }
        drawView.postInvalidate();
        return false;
    }
}
