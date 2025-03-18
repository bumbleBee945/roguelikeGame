package gameCode;

import java.util.Scanner;

import static gameCode.gameMain.random;

public class gameMap {
    //attributes
    private Scanner input = new Scanner(System.in);
    private int floor;
    private gamePlayer player;
    private int[] count = new int[8];
    private gameRoom[][] room = new gameRoom[8][4];

    //constructors
    private gameMap() {}
    public gameMap(int floor, gamePlayer player) {
        setFloor(floor);
        setPlayer(player);
    }

    //accessors
    public int getFloor() { return floor; }

    //mutators
    public void setFloor(int floor) { this.floor = floor; }
    public void setPlayer(gamePlayer player) { this.player = player; }

    //methods
    public void generate() {
        count[7] = 1;
        room[7][0] = new gameRoom("bossA");
        room[7][1] = new gameRoom();
        room[7][2] = new gameRoom();
        room[7][3] = new gameRoom();
        int roomNum;
        boolean validMap = false;
        do { // generate a map
            int roomAmount = 0;
            int[] numAmount = new int[4];
            numAmount[0]++;
            numAmount[3]++; // make 0/4 count like there's one more
            for (int i = 0; i < 7; i++) { // generate rooms
                do {
                    roomNum = random(1, 4); // count of rooms 1-4
                    numAmount[roomNum-1]++;
                } while ((i > 0) && ((roomNum-count[i-1] == 3) || (roomNum-count[i-1] == -3))); // if roomNum/count are 4 and 1
                for (int j = 0; j < 4; j++) // add all rooms for a tier
                    if (j < roomNum) { //if roomNum is 3 this fills 0/1/2
                        room[i][j] = randomRoom();
                        roomAmount++;
                    }
                count[i] = roomNum; //set count of this floor
            }
            int enemy = 0; // check requirements
            boolean cache = false;
            boolean unknown = false;
            boolean store = false;
            boolean brute = false;
            for (int i = 0; i < room.length; i++) // loop all rooms
                for (int j = 0; j < count[i]; j++) {
                    switch (room[i][j].getType()) {
                        case "enemy":
                            enemy++;
                            break;
                        case "cache":
                            cache = true;
                            break;
                        case "store":
                            store = true;
                            break;
                        case "brute":
                            brute = true;
                            break;
                        case "unknown":
                            unknown = true;
                            break;
                    }
                }
            boolean amount = ((roomAmount >= 16) && (roomAmount <= 18));
            for (int i = 0; i < 4; i++)
                if (numAmount[i] >= 4)
                    amount = false;
            // <4 of a r-num / 16-18 rooms / min 1 store(5) / min 1 cache(4) / min 1 brute(3) / min 1 unknown(2) / min 7 enemies(1)
            if (amount && cache && store && unknown && brute && (enemy >= 7))
                validMap = true;
        } while (!validMap);
    }
    private gameRoom randomRoom() {
        String type;
        int percent = random(1, 100);
        if (percent <= 65) type = "enemy";
        else if (percent <= 77) type = "unknown";
        else if (percent <= 87) type = "brute";
        else if (percent <= 95) type = "cache";
        else if (percent <= 99) type = "store";
        else type = "error";
        return new gameRoom(type);
    }
    public void move(int option) {
        player.setRoom(player.getLevel()+1, option);
        printAll();
        System.out.print("[=] ");
        input.nextLine();
    }
    public void encounter() {
        gameRoom current = room[player.getLevel()][player.getRoom()];
        switch (current.getType()) {
            case "enemy":
                new gameCombat(current, player).combat();
                break;
            case "brute":
                new gameCombat(current, player).combat();
                break;
        }
    }


    //displays
    public void display() {
        printAll();
        String next;
        String[] opt = new String[]{"AAA", "BBB", "CCC", "DDD"};
        for (int i = count[player.getLevel()+1]; i < 4; i++)
            opt[i] = "NULL";
        while (true) { // get input
            System.out.print("[-] ");
            next = input.nextLine().toUpperCase();
            if (!next.matches("...") || (!next.equals("MMI")) && (!next.equals("EXI") && !next.equals(opt[0]) &&
                    !next.equals(opt[1]) && !next.equals(opt[2]) && !next.equals(opt[3]))) { //is it invalid
                printAll();
                System.out.print("[x] Invalid input / ");
                continue;
            }
            if (next.equals("MMI")) {
                player.display();
                printAll();
                continue;
            } else if (next.equals("EXI"))
                System.exit(1);
            break;
        }
        for (int i = 0; i < 4; i++) // move to option
            if (opt[i].equals(next))
                move(i);
    }
    private void printAll() {
        printTop();
        printBoss(room[7][1]);
        printMiddle();
        printBottom();
    }
    private void printTop() {
        System.out.printf("\n\n" +
                          "    |-----------------------------------------------------------------------------------------------------------------------------------|\n" +
                          "    |                                                             Floor  %d                                                              |\n" +
                          "    |                                                                                                                                   |\n",
                          getFloor());
    }
    private void printBoss(gameRoom boss) {
        System.out.printf("    |                                       [===================================================]                                       |\n" +
                          "    |                                       |                                                   |                                       |\n" +
                          "    |                                       |                    %11s                    |                                       |\n" +
                          "    |                                       |                                                   |                                       |\n" +
                          "    |                                       [========================%3s========================]                                       |\n",
                          room[7][0].getName(), (player.getLevel() == 7 ? "MMI" : (player.getLevel() == 6 ? "AAA" : "===")));
    }
    private void printMiddle() {
        for (int i = 6; i > -1; i--) {
            System.out.print(routes(i));
            System.out.print(roomString(i));
        }
    }
    private String routes(int level) {
        int b = count[level];
        int t = count[level+1];
        if (b == 4) b = 8;
        else if (b == 3) b = 4;
        if (t == 4) t = 8;
        else if (t == 3) t = 4;
        switch (t - b) {
            case 6: return "    |                                  ╲               |             ╲ ╱             |               ╱                                  |\n" +
                           "    |                                    ╲             |             ╱ ╲             |             ╱                                    |\n";
            case 4: return "    |                           \\               /             \\               /             \\               /                           |\n" +
                           "    |                            \\             /               \\             /               \\             /                            |\n";
            case 3: return "    |                                                 ╲               |               ╱                                                 |\n" +
                           "    |                                                   ╲             |             ╱                                                   |\n";
            case 2: return "    |                                          \\               /             \\               /                                          |\n" +
                           "    |                                           \\             /               \\             /                                           |\n";
            case 1: return "    |                                                         \\               /                                                         |\n" +
                           "    |                                                          \\             /                                                          |\n";
            case -1: return "    |                                                          /             \\                                                          |\n" +
                            "    |                                                         /               \\                                                         |\n";
            case -2: return "    |                                           /             \\               /             \\                                           |\n" +
                            "    |                                          /               \\             /               \\                                          |\n";
            case -3: return "    |                                                   ╱             |             ╲                                                   |\n" +
                            "    |                                                 ╱               |               ╲                                                 |\n";
            case -4: return "    |                            /             \\               /             \\               /             \\                            |\n" +
                            "    |                           /               \\             /               \\             /               \\                           |\n";
            case -6, -7: return "    |                                    ╱             |             ╲ ╱             |             ╲                                    |\n" +
                                "    |                                  ╱               |             ╱ ╲             |               ╲                                  |\n";
            case 0: switch (b) {
                case 8: return "    |                    |             ╲ ╱             |             ╲ ╱             |             ╲ ╱             |                    |\n" +
                               "    |                    |             ╱ ╲             |             ╱ ╲             |             ╱ ╲             |                    |\n";
                case 4: return "    |                                   |             ╲ ╱             |             ╲ ╱             |                                   |\n" +
                               "    |                                   |             ╱ ╲             |             ╱ ╲             |                                   |\n";
                case 2: return "    |                                                  |             ╲ ╱             |                                                  |\n" +
                               "    |                                                  |             ╱ ╲             |                                                  |\n";
                case 1: return "    |                                                                 |                                                                 |\n" +
                               "    |                                                                 |                                                                 |\n";
            }
        }
        return "null";
    }
    private String roomString(int level) {
        StringBuilder[] line = {new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder()};
        String[] opt = new String[]{"AAA", "BBB", "CCC", "DDD"};
        int spaceNum = 2 + ((4 - count[level]) * 15);
        String spaces = " ".repeat(spaceNum);
        for (int i = 0; i < 5; i++)
            line[i].append(spaces);
        for (int i = 0; i < count[level]; i++) {
            line[0].append("       [=====================]");
            line[1].append("       |                     |");
            line[2].append(String.format("       |     %11s     |", room[level][i].getName()));
            line[3].append("       |                     |");
            line[4].append(String.format("       [=========%3s=========]", // display aaa / bbb / ccc / ddd / mmi / ===
                ((player.getLevel() == level) && player.getRoom() == i ? "MMI" : (player.getLevel() == level+-1) ? opt[i] : "===")));
        }
        for (int i = 0; i < 5; i++)
            line[i].append(spaces);
        return String.format("    |%s       |    \n" +
                             "    |%s       |    \n" +
                             "    |%s       |    \n" +
                             "    |%s       |    \n" +
                             "    |%s       |    \n",
                             line[0], line[1], line[2], line[3], line[4]);
    }
    private void printBottom() {
        System.out.printf("    |                                                                                                                                   |\n" +
                         "    |----------------------------------------------------------------%3s----------------------------------------------------------------|\n\n",
                         (player.getLevel() == -1 ? "MMI" : "---"));
    }
}
