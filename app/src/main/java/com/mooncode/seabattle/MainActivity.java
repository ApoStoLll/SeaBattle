package com.mooncode.seabattle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new Controller();
        GameView gameView = new GameView(controller.getPlayer1(), controller.getPlayer2());
        setContentView(gameView.new DrawView(this));
    }

}
