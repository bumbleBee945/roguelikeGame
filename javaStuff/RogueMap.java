public class RogueMap {

    //attributes
    private int floor;
    private String[] roomNames = new String[]{
            "   Error   ", "   Enemy   ", "  Unknown  ",
            "   Brute   ", "   Cache   ", "   Store   ",
            " ???#?$!?? ", "   Error   ", "   Error   ", "  Boss  A  "
    };
    private int[][] roomArray = new int[8][4];

    //constructor
    public RogueMap(int floor) { this.floor = floor; }

    //methods
    public void printMap() {
        printMapTop();
        printBoss(roomArray[0][2]);
        for (int i = 0; i < 7; i++) {
            printRoutes(roomArray[i][0] - roomArray[i+1][0], roomArray[i][0]);
            printRooms(roomArray[i+1]);
        }
        printMapBottom();
    }

    public void generateMap() {
        roomArray[0][0] = 1;
        roomArray[0][1] = -1;
        roomArray[0][2] = 9;
        roomArray[0][1] = -1;
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
                    roomArray[i][j] = randomRoom();
                    roomsAdded[roomArray[i][j]]++; // count types added
                }
                switch (roomNum) { // remove rooms
                    case 1:
                        roomArray[i][0] = 1;
                        roomsAdded[roomArray[i][1]]--;
                        roomArray[i][1] = -1;
                        roomsAdded[roomArray[i][3]]--;
                        roomArray[i][3] = -1;
                        roomAmount -= 2;
                        break;
                    case 2:
                        roomArray[i][0] = 2;
                        roomsAdded[roomArray[i][2]]--;
                        roomArray[i][2] = -1;
                        roomAmount--;
                        break;
                    case 3:
                        roomArray[i][0] = 4;
                        break;
                }
            }
            // 13-14 rooms / min 1 store(5) / min 1 cache(4) / min 1 brute(3) / min 1 unknown(2) / min 7 enemies(1)
            if ((roomAmount >= 13) && (roomAmount <= 14) &&
                    (roomsAdded[5] >= 1) && (roomsAdded[4] >= 1) && (roomsAdded[3] >= 1) && (roomsAdded[2] >= 1) && (roomsAdded[1] >= 7))
                validMap = true;
        }
    }

    private int randomRoom() {
        int percent = 1 + (int)(Math.random() * 100);
        if (percent <= 65) return 1;
        else if (percent <= 77) return 2;
        else if (percent <= 87) return 3;
        else if (percent <= 95) return 4;
        else if (percent <= 99) return 5;
        else if (percent == 100) return 6;
        else return 0;
    }

    private void printRooms(int[] rooms) {
        switch (rooms[0]) {
            case 4:
                System.out.printf(
                        "    |         [=====================]       [=====================]       [=====================]         |\n" +
                                "    |         |                     |       |                     |       |                     |         |\n" +
                                "    |         |     %s     |       |     %s     |       |     %s     |         |\n" +
                                "    |         |                     |       |                     |       |                     |         |\n" +
                                "    |         [=====================]       [=====================]       [=====================]         |\n",
                        this.roomNames[rooms[1]], this.roomNames[rooms[2]], this.roomNames[rooms[3]]);
                break;
            case 2:
                System.out.printf(
                        "    |                        [=====================]       [=====================]                        |\n" +
                                "    |                        |                     |       |                     |                        |\n" +
                                "    |                        |     %s     |       |     %s     |                        |\n" +
                                "    |                        |                     |       |                     |                        |\n" +
                                "    |                        [=====================]       [=====================]                        |\n",
                        this.roomNames[rooms[1]], this.roomNames[rooms[3]]);
                break;
            case 1:
                System.out.printf(
                        "    |                                       [=====================]                                       |\n" +
                                "    |                                       |                     |                                       |\n" +
                                "    |                                       |     %s     |                                       |\n" +
                                "    |                                       |                     |                                       |\n" +
                                "    |                                       [=====================]                                       |\n",
                        this.roomNames[rooms[2]]);
                break;
        }
    }

    private void printRoutes(int type, int rooms) {
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

    private void printBoss(int bossNum) {
        System.out.printf(
                "    |                                  [===============================]                                  |\n" +
                        "    |                                  |                               |                                  |\n" +
                        "    |                                  |          %s          |                                  |\n" +
                        "    |                                  |                               |                                  |\n" +
                        "    |                                  [===============================]                                  |\n", this.roomNames[bossNum]);
    }

    private void printMapTop() {
        System.out.printf(
                "\n\n    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                              Floor  %d                                               |\n" +
                        "    |                                                                                                     |\n", this.floor);
    }

    private void printMapBottom() {
        System.out.print(
                "    |                                                                                                     |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n\n");
    }
}