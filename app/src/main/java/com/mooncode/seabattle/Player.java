package com.mooncode.seabattle;

public class Player {
    private Ship[] fleet;
    private Map field;
    Player(){
        field = new Map(this);
        randomFleet();
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
    void randomFleet(){
        fleet = new Ship[1]; //10
        //fleet[0] = randomShip(4,0);
        //for(int i = 1;i<3;i++) fleet[i] = randomShip(3,i);
        //for(int i = 3;i<6;i++) fleet[i] = randomShip(2,i);
        //for(int i = 6;i<10;i++) fleet[i] = randomShip(1,i);
        for(int i = 0;i<1;i++) fleet[i] = randomShip(1,i);
    }
    Ship randomShip(int deck,int num){
        Coordinate coor = new Coordinate();
        int x = coor.getCoordinate('x');
        int y = coor.getCoordinate('y');
        while(check(x,y)){
            coor.random();
        }
        //if (true) {
            Coordinate[] position = new Coordinate[deck];
            position[0] = coor;
            this.field.setShip(coor,num);
            Ship boat = new Ship(deck,num,position);
            return boat;
       // }

        //int rand = (int)(Math.random()*1000);
       // if (rand%4==0){x++; if(check(x,y));}
        //if (rand%4==1){y++;}
       // if (rand%4==2){x--;}
       // if (rand%4==3){y--;}
    }
    boolean check(int x,int y){
        if (x > 10 || y > 10 || x < 0 || y < 0) return true;
        for(int i = x-1;i<x+2;i++){
            for(int j = y-1;j<y+2;j++){
                if (i < 10 & j < 10 & i > -1 & j > -1)
                    if (field.getInfo(i,j)) return true;
            }
        }
        return false;
    }
    Map getField(){ return field; }
}
