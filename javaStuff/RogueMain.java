import java.util.Scanner;

public class RogueMain {
    public static void main(String[] args) {
        RogueMap floorMap = new RogueMap(1);
        RoguePlayer player = new RoguePlayer();
        RogueCombat combat;
        Scanner input = new Scanner(System.in);
        String givenValue;
        int givenInt;
        floorMap.generateMap();
        boolean exitProgram = false;
        while (exitProgram == false) {
            while (true) {
                System.out.print("[1] Print Map\n[2] Oozes\n[3] Crazed Cultist\n[4] Generate Map\n[5] Exit Program\n[-] ");
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
                    combat = new RogueCombat("oozes", player);
                    System.out.print("[-] ");
                    givenValue = input.nextLine();
                    break;
                case 3:
                    combat = new RogueCombat("crazedCultist", player);
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