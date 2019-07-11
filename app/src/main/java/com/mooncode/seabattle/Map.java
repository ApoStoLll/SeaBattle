package com.mooncode.seabattle;

public class Map {
    private  int[][] field; // 0 - clear, -1 - shot, 2-3-... - ship
    public Map(){
        field = new int[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                this.field[i][j]=0;
            }
        }
    }
    int shot(Coordinate a, Player b){    // 0 - error, 1 - miss, 2 - hurt, 3 - kill
        if (field[a.getCoordinate('x')][a.getCoordinate('y')] == 0) {
            field[a.getCoordinate('x')][a.getCoordinate('y')] = -1;
            return 1;
        }
        if (field[a.getCoordinate('x')][a.getCoordinate('y')] > 0) {
            if( b.getShip(field[a.getCoordinate('x')][a.getCoordinate('y')]).getHp() == 1 ) return 3;
            else return 2;
        }
        else return 0;
    }
}
