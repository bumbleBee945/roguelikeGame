package gameCode;

import java.util.Scanner;

public class gameMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String givenValue;
        int floor = 1;
        //initStatuses();
        gamePlayer player = new gamePlayer();
        gameMap map = new gameMap(floor, player);
        map.generate();
        for (int i = 0; i < 4; i++) {
            while (player.getLevel() != 7) {
                map.display();
            }
            map = new gameMap(++floor, player);
            map.generate();
            player.setRoom(-1, 0);
        }
    }
}