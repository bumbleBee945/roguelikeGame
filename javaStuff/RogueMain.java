public class RogueMain {
    public static void main(String[] args) {
        RogueMap floorMap = new RogueMap(1);
        floorMap.generateMap();
        floorMap.printMap();
    }

    static void printMap(int floor, String[] roomNames, int[][] roomArray) {
    }

    static String[] initRoomNames() {
        return new String[]{
                "   Error   ", "   Enemy   ", "  Unknown  ",
                "   Brute   ", "   Cache   ", "   Store   ",
                " ???#?$!?? ", "   Error   ", "   Error   ", "  Boss  A  "
        };
    }

    static int[][] generateMap() {
        int[][] tempArray = new int[8][4];
        tempArray[0][0] = 1; tempArray[0][1] = -1; tempArray[0][2] = 9; tempArray[0][3] = -1; // boss room
        int[] roomsAdded = new int[7];
        int roomNum;
        boolean validMap = false;
        while (validMap == false) { // generate a map
            int roomAmount = 0;
            for (int i = 1; i < 7; i++) // clear roomsAdded
                roomsAdded[i] = 0;
            for (int i = 1; i < 8; i++) { // generate rooms
                roomNum = 1 + (int) (Math.random() * 3);
                for (int j = 1; j < 4; j++, roomAmount++) { // add all rooms for a tier
                    tempArray[i][j] = randomRoom();
                    roomsAdded[tempArray[i][j]]++; // count types added
                }
                switch (roomNum) { // remove rooms
                    case 1:
                        tempArray[i][0] = 1;
                        roomsAdded[tempArray[i][1]]--;
                        tempArray[i][1] = -1;
                        roomsAdded[tempArray[i][3]]--;
                        tempArray[i][3] = -1;
                        roomAmount -= 2;
                        break;
                    case 2:
                        tempArray[i][0] = 2;
                        roomsAdded[tempArray[i][2]]--;
                        tempArray[i][2] = -1;
                        roomAmount--;
                        break;
                    case 3:
                        tempArray[i][0] = 4;
                        break;
                }
            }
            // 13-14 rooms / min 1 store(5) / min 1 cache(4) / min 1 brute(3) / min 1 unknown(2) / min 7 enemies(1)
            if ((roomAmount >= 13) && (roomAmount <= 14) &&
                (roomsAdded[5] >= 1) && (roomsAdded[4] >= 1) && (roomsAdded[3] >= 1) && (roomsAdded[2] >= 1) && (roomsAdded[1] >= 7))
                validMap = true;
        }
        return tempArray;
    }
    
    static int randomRoom() {
        int percent = 1 + (int)(Math.random() * 100);
        if (percent <= 65) return 1;
        else if (percent <= 77) return 2;
        else if (percent <= 87) return 3;
        else if (percent <= 95) return 4;
        else if (percent <= 99) return 5;
        else if (percent == 100) return 6;
        else return 0;
    }

    static void printRooms(int[] rooms, String[] roomNames) {
        switch (rooms[0]) {
            case 4:
                System.out.printf(
                        "    |         [=====================]       [=====================]       [=====================]         |\n" +
                        "    |         |                     |       |                     |       |                     |         |\n" +
                        "    |         |     %s     |       |     %s     |       |     %s     |         |\n" +
                        "    |         |                     |       |                     |       |                     |         |\n" +
                        "    |         [=====================]       [=====================]       [=====================]         |\n",
                        roomNames[rooms[1]], roomNames[rooms[2]], roomNames[rooms[3]]);
                break;
            case 2:
                System.out.printf(
                        "    |                        [=====================]       [=====================]                        |\n" +
                        "    |                        |                     |       |                     |                        |\n" +
                        "    |                        |     %s     |       |     %s     |                        |\n" +
                        "    |                        |                     |       |                     |                        |\n" +
                        "    |                        [=====================]       [=====================]                        |\n",
                        roomNames[rooms[1]], roomNames[rooms[3]]);
                break;
            case 1:
                System.out.printf(
                        "    |                                       [=====================]                                       |\n" +
                        "    |                                       |                     |                                       |\n" +
                        "    |                                       |     %s     |                                       |\n" +
                        "    |                                       |                     |                                       |\n" +
                        "    |                                       [=====================]                                       |\n",
                        roomNames[rooms[2]]);
                break;
        }
    }

    static void printRoutes(int type, int rooms) {
        switch (type) {
            case 3:
                System.out.print("    |                                  ╲               |               ╱                                  |\n" +
                                 "    |                                    ╲             |             ╱                                    |\n");
                break;
            case 2:
                System.out.print("    |                           \\               /             \\               /                           |\n" +
                                 "    |                            \\             /               \\             /                            |\n");
                break;
            case 1:
                System.out.print("    |                                          \\               /                                          |\n" +
                                 "    |                                           \\             /                                           |\n");
                break;
            case 0:
                switch (rooms) {
                    case 4:
                        System.out.print("    |                    |             ╲ ╱             |             ╲ ╱             |                    |\n" +
                                         "    |                    |             ╱ ╲             |             ╱ ╲             |                    |\n");
                        break;
                    case 2:
                        System.out.print("    |                                   |             ╲ ╱             |                                   |\n" +
                                         "    |                                   |             ╱ ╲             |                                   |\n");
                        break;
                    case 1:
                        System.out.print("    |                                                  |                                                  |\n" +
                                         "    |                                                  |                                                  |\n");
                        break;
                }
                break;
            case -1:
                System.out.print("    |                                           /             \\                                           |\n" +
                                 "    |                                          /               \\                                          |\n");
                break;
            case -2:
                System.out.print("    |                            /             \\               /             \\                            |\n" +
                                 "    |                           /               \\             /               \\                           |\n");
                break;
            case -3:
                System.out.print("    |                                    ╱             |             ╲                                    |\n" +
                                 "    |                                  ╱               |               ╲                                  |\n");
                break;
        }
    }

    static void printBoss(int bossNum, String[] roomNames) {
        System.out.printf(
                "    |                                  [===============================]                                  |\n" +
                "    |                                  |                               |                                  |\n" +
                "    |                                  |          %s          |                                  |\n" +
                "    |                                  |                               |                                  |\n" +
                "    |                                  [===============================]                                  |\n", roomNames[bossNum]);
    }

    static void printMapTop(int floor) {
        System.out.printf(
                "\n\n    |-----------------------------------------------------------------------------------------------------|\n" +
                "    |                                              Floor  %d                                               |\n" +
                "    |                                                                                                     |\n", floor);
    }

    static void printMapBottom() {
        System.out.print(
                "    |                                                                                                     |\n" +
                "    |-----------------------------------------------------------------------------------------------------|\n\n");
    }
}