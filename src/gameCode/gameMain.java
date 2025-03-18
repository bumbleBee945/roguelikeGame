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
                map.encounter();
            }
            map = new gameMap(++floor, player);
            map.generate();
            player.setRoom(-1, 0);
        }
    }

    public static String midFormat(String str, int total) {
        str += (str.length() % 2 == 0 ? " " : "");
        String sideAdd = " ".repeat((total - str.length()) / 2);
        return String.format("%s%s%s", sideAdd, str, sideAdd);
    }
    public static void printTop(String str) {
        System.out.printf("\n\n    |%s|\n", "-".repeat(131));
        System.out.printf("    |%s|\n", midFormat(str, 131));
    }
    public static void printBottom(String str1, String str2) {
        System.out.printf("    |%131s|\n", "-".repeat(131));
        System.out.printf("    |%s|\n", midFormat(str1, 131));
        System.out.printf("    |%s|\n", midFormat(str2, 131));
        System.out.printf("    |%131s|\n\n", "-".repeat(131));
    }
    public static String randomItemCode(String str) {
        String[] codes = new String[]{"KNI", "HER", "SAL"};
        String pickup;
        do {
            pickup = codes[(int)(Math.random() * codes.length)];
        } while (new gameItem(pickup).getTier().equals(str));
        return pickup;
    }
    public static String randomArtifactCode(String str) {
        String[] codes = new String[]{"BER", "SPI", "IVN"};
        String pickup;
        do {
            pickup = codes[(int)(Math.random() * codes.length)];
        } while (new gameArtifact(pickup).getTier().equals(str));
        return pickup;
    }
    public static int random(int min, int max) {
        return (int)(Math.random() * (min + 1)) + (max-min);
    }
}