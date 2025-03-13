package gameCode;

import java.util.ArrayList;
import java.util.Scanner;

public class gameCombat {
    //attributes
    gameRoom room;
    gamePlayer player;
    private ArrayList<gameEnemy> enemy = new ArrayList<>();

    //constructors
    public gameCombat() {
        setNull();
    }
    public gameCombat(gameRoom room, gamePlayer player) {
        setRoom(room);
        setPlayer(player);
    }

    //accessors
    public gameRoom getRoom() { return this.room; }
    public gamePlayer getPlayer() { return this.player; }
    public ArrayList<gameEnemy> getList() { return this.enemy; }

    //mutators
    public void setRoom(gameRoom room) { this.room = room; }
    public void setPlayer(gamePlayer player) { this.player = player; }

    //methods
    public void combat() {
        for (int i = 0; i < room.getEnemyCount(); i++)
            enemy.add(new gameEnemy(room.getEnemy(i)));
    }

    //initializers
    private void setNull() {
        System.exit(60);
    }

    //displays
}
