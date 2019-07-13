package com.mooncode.seabattle;

public class Player {
    private Ship[] fleet;
    private Map field;
    Player(){
        field = new Map(this);
    }
    public class Ship {
        private Coordinate[] position;
        private int hp;
        private int number;
        Ship(int hp,int number, Coordinate[] position){
            this.hp = hp;
            this.position = position;
            this.number = number;
        }
        int getHp() { return this.hp; }
        void shot() {this.hp--; }
        int getNumber() { return this.number; }
    }
    Ship getShip (int num){ return fleet[num]; }
    Ship[] getFleet() { return fleet; }
    void randomShip(int deck){
        Coordinate coor = new Coordinate();
        while(check(coor)){
            coor.random();
        }
        if (deck == 1) {}//добавить корабль во флот
        int x = coor.getCoordinate('x');
        int y = coor.getCoordinate('y');
        int rand = (int)(Math.random()*1000);
        if (rand%4==0){x++;}
        if (rand%4==1){y++;}
        if (rand%4==2){x--;}
        if (rand%4==3){y--;}
    }
    boolean check(Coordinate coor){
        int x = coor.getCoordinate('x');
        int y = coor.getCoordinate('y');
        if (field.getInfo(x,y)) return true;
        if(((x+1)<10)&((y+1)<10))  if (field.getInfo(x+1,y+1)) return true;
        if(((x+1)<10)&((y)<10))  if (field.getInfo(x+1,y)) return true;
        if(((x+1)<10)&((y-1)<10))  if (field.getInfo(x+1,y-1)) return true;
        if(((x-1)<10)&((y+1)<10))  if (field.getInfo(x-1,y+1)) return true;
        if(((x-1)<10)&((y)<10))  if (field.getInfo(x-1,y)) return true;
        if(((x-1)<10)&((y-1)<10))  if (field.getInfo(x-1,y-1)) return true;
        if(((x)<10)&((y+1)<10))  if (field.getInfo(x+1,y+1)) return true;
        if(((x)<10)&((y-1)<10))  if (field.getInfo(x+1,y-1)) return true;
        return false;
    }
    Map getField(){ return field; }
}
