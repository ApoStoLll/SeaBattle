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
        while(!field.getInfo(coor)){
            coor.random();
        }

    }
    Map getField(){ return field; }
}
