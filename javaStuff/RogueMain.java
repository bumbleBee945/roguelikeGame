import java.util.Scanner;

public class RogueMain {

    public static void main(String[] args) {
        RogueStatus.initStatuses();
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
                System.out.print("[1] Print Map\n[2] Oozes\n[3] Crazed Cultist\n[4] Crazed Cultist x3\n[5] Generate Map\n[6] Exit Program\n[-] ");
                givenValue = input.nextLine();
                if (!givenValue.matches("[1-6]")) {
                    System.out.print("That input is invalid. It must be 1, 2, 3, 4, or 5.\n");
                    continue;
                }
                givenInt = Integer.parseInt(givenValue);
                break;
            }
            switch (givenInt) {
                case 1:
                    floorMap.printMap();
                    System.out.print("[=] ");
                    givenValue = input.nextLine();
                    break;
                case 2:
                    combat = new RogueCombat("oozes", player);
                    System.out.print("[=] ");
                    givenValue = input.nextLine();
                    break;
                case 3:
                    combat = new RogueCombat("crazedCultist", player);
                    System.out.print("[=] ");
                    givenValue = input.nextLine();
                    break;
                case 4:
                    combat = new RogueCombat("crazedCultist3", player);
                    System.out.print("[=] ");
                    givenValue = input.nextLine();
                    break;
                case 5:
                    floorMap.generateMap();
                    System.out.print("\n\nMap generated.\n\n\n");
                    break;
                case 6:
                    exitProgram = true;
                    break;
            }
        }
    }
}