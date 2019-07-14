package com.mooncode.seabattle;

public class Map {
    private  int[][] field; // -3 - dead(hurt) ship, -2 - clear, -1 - shot, 0-1-2-3-... - num of ship
    private Player player;
    public Map(Player player){
        this.player = player;
        field = new int[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                this.field[i][j] = -2;
            }
        }
    }
    int shot(Coordinate coor){    // 0 - error, 1 - miss, 2 - hurt, 3 - kill
        if (field[coor.getCoordinate('x')][coor.getCoordinate('y')] == -2) {
            field[coor.getCoordinate('x')][coor.getCoordinate('y')] = -1;
            return 1;
        }
        if (field[coor.getCoordinate('x')][coor.getCoordinate('y')] > -1) {
            player.getShip(field[coor.getCoordinate('x')][coor.getCoordinate('y')]).shot();
            field[coor.getCoordinate('x')][coor.getCoordinate('y')] = -3;
            if( player.getShip(field[coor.getCoordinate('x')][coor.getCoordinate('y')]).getHp() == 1 )
                // обвести корабль
                return 3;
            else
                return 2;
        }
        else return 0;
    }
    boolean getInfo(int x,int y){
        if (field[x][y] == -2) return false;
        else return true;
    }
    void setShip(Coordinate coor,int num){
        field[coor.getCoordinate('x')][coor.getCoordinate('y')] = num;
    }
    int[][] getField(){ return field;}
}
