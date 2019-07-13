package com.mooncode.seabattle;

public class Coordinate {
    private int x,y;
    public Coordinate(){
        this.x = (int)(Math.random()*10);
        this.y = (int)(Math.random()*10);
    }
    void random(){
        this.x = (int)(Math.random()*10);
        this.y = (int)(Math.random()*10);
    }
    void setCoordinate(int x,int y){
        this.x = x;
        this.y = y;
    }
    int getCoordinate(char a){
        if(a == 'x') return this.x;
        if(a == 'y') return this.y;
        else return 0;
    }
}