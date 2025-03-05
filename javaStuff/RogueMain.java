import java.util.Scanner;

public class RogueMain {
    public static void main(String[] args) {
        RogueMap floorMap = new RogueMap(1);
        floorMap.generateMap();
        Scanner input = new Scanner(System.in);
        String givenValue;
        int givenInt;
        boolean exitProgram = false;
        while (exitProgram == false) {
            while (true) {
                System.out.print("[1] Print Map\n[2] Print Combat\n[3] Print Map/Combat\n[4] Generate Map\n[5] Exit Program\n[-] ");
                givenValue = input.nextLine();
                if (!givenValue.matches("[1-5]")) {
                    System.out.print("That input is invalid. It must be 1, 2, 3, 4, or 5.\n");
                    continue;
                }
                givenInt = Integer.parseInt(givenValue);
                break;
            }
            switch (givenInt) {
                case 1:
                    floorMap.printMap();
                    System.out.print("[-] ");
                    givenValue = input.nextLine();
                    break;
                case 2:
                    RogueCombat.printGUI();
                    System.out.print("[-] ");
                    givenValue = input.nextLine();
                    break;
                case 3:
                    floorMap.printMap();
                    System.out.print("[-] ");
                    givenValue = input.nextLine();
                    RogueCombat.printGUI();
                    System.out.print("[-] ");
                    givenValue = input.nextLine();
                    break;
                case 4:
                    floorMap.generateMap();
                    System.out.print("Map generated.\n");
                    break;
                case 5:
                    exitProgram = true;
                    break;
            }
        }
    }
}