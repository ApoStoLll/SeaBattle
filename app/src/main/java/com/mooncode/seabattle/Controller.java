package com.mooncode.seabattle;

public class Controller {
    private Player player1;
    private Player player2;
    private Coordinate coords;
    private int step = 0;
    Controller(){
        player1 = new Player();
        player2 = new Player();
    }

   /* public int gameBody(){
        //while(player1.getFleet().length > 0 && player2.getFleet().length > 0){
        //Game
        if(step % 2 == 0){
            //First player
            return player2.getField().shot(coords);
        }
        else{
            //Secont player
            return player1.getField().shot(coords);
        }
    }*/
    void push(Coordinate coords){
        this.coords = coords;
        //int res = 0;
        if(step % 2 == 0){
            //First player
             player2.getField().shot(coords);
        }
        else{
            //Secont player
             player1.getField().shot(coords);
        }
        step++;
    }
    Player getPlayer1(){ return player1; }
    Player getPlayer2(){ return player2; }
    int getStep(){ return step; }

}
