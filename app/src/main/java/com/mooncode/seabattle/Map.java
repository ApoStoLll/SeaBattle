package com.mooncode.seabattle;

public class Map {
    private  int[][] field; // 0 - clear, 1 - shot, 2 - ship
    public Map(){
        field = new int[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                this.field[i][j]=0;
            }
        }
    }
    int shot(int a, int b){    // 0 - miss, 1 - hurt, 2 - kill
        if (field[a][b] == 0) return 0;
        else return 1;
        //if (field[a][b] == 1) return 1;
    }
}
