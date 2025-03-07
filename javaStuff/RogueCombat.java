import java.util.Scanner;
import java.util.ArrayList;

public class RogueCombat {
    //attributes
    private String encounter;
    private int enemyCount;
    private int round;
    private String action;
    private RoguePlayer player;
    private String givenValue;
    private Scanner input = new Scanner(System.in);
    private String[] charArray = new String[18];
    private ArrayList<RogueEnemy> enemy = new ArrayList<>();

    //constructors
    public RogueCombat(String encounter, RoguePlayer player) {
        this.player = player;
        this.encounter = encounter;
        initCombat();
        this.round = 1;
        playerTurn();
    }

    private void playerTurn() {
        this.action = "playerTurn";
        printGUI();
        while (true) {
            System.out.print("[-] ");
            givenValue = input.nextLine().toUpperCase();
            if (!givenValue.matches("...") || (returnAction(givenValue) == "none")) {
                printGUI();
                System.out.print("[x] Invalid input / ");
                continue;
            }
            break;
        }
        doAction(returnAction(givenValue), givenValue);
    }

    //accessors

    //methods
    private void doAction(String type, String code) {
        switch (type) {
            case "end":
                break;
            case "active":
                break;
            case "player":
                player.display();
                System.out.print("[=] ");
                givenValue = input.nextLine();
                playerTurn();
                break;
            case "enemy":
                if (this.action.equals("playerTurn")) {
                    enemy.get(findEnemy(code)).display();
                    System.out.print("[=] ");
                    givenValue = input.nextLine();
                    playerTurn();
                    break;
                }
                break;
            case "item":
                this.player.displayItem(this.player.findItem(code));
                System.out.print("[=] ");
                givenValue = input.nextLine();
                playerTurn();
                break;
            case "artifact":
                this.player.displayArtifact(this.player.findArtifact(code));
                System.out.print("[=] ");
                givenValue = input.nextLine();
                playerTurn();
                break;
        }
    }

    private int findEnemy(String code) {
        for (int i = 0; i < enemy.size(); i++)
            if (enemy.get(i).getCode().equals(code))
                return i;
        return -1;
    }

    private String returnAction(String code) {
        if (code.equals("END"))
            return "end";
        if (code.equals("ACT"))
            return "active";
        if (code.equals("MMI"))
            return "player";
        for (int i = 0; i < enemyCount; i++)
            if (enemy.get(i).getCode().equals(code))
                return "enemy";
        for (int i = 0; i < 6; i++)
            if (this.player.findItem(code) != -1)
                return "item";
        for (int i = 0; i < 10; i++)
            if (this.player.findArtifact(code) != -1)
                return "artifact";
        return "none";
    }

    private void initCombat() {
        switch (this.encounter) {
            case "crazedCultist":
                this.enemyCount = 1;
                enemy.add(new RogueEnemy("CUL"));
                break;
            case "crazedCultist3":
                this.enemyCount = 3;
                enemy.add(new RogueEnemy("CUL"));
                enemy.add(new RogueEnemy("CUL"));
                enemy.add(new RogueEnemy("CUL"));
                break;
            case "oozes":
                this.enemyCount = 2;
                enemy.add(new RogueEnemy("GOO"));
                enemy.add(new RogueEnemy("BOO"));
                break;
        }
    }

    private void printGUI() {
        printTop();
        printCharacters();
        printActive();
        printArtifacts();
        printItems();
        printBottom();
    }

    private void setCharArray() {
        for (int i = 0; i < 18; i++)
            charArray[i] = "                            ";
        int start = 0;
        int plus = 0;
        if (this.enemyCount == 1) {
            start = 5;
            plus = 3;
        } else if (this.enemyCount == 2) {
            start = 1;
            plus = 1;
        }
        for (int i = 0; i < enemyCount; i++) {
            charArray[start++] = String.format("|----------%s--%d----------|", enemy.get(i).getCode(), i+1);
            charArray[start++] = String.format("| %s |", enemy.get(i).getName());
            charArray[start++] = "|--------------------------|";
            start += plus;
            charArray[start++] = String.format("   [INTENT] (%s * %-2d)   ", enemy.get(i).getIntentType(), enemy.get(i).getIntentNum());
            charArray[start++] = String.format("     [HEALTH] (%3d/%-3d)     ", enemy.get(i).getHealth(), enemy.get(i).getMaxHealth());
            charArray[start++] = "          [      ]          ";
            start += (plus + plus);
        }
    }

    private void printTop() {
        System.out.print("\n\n" +
                "    |-----------------------------------------------------------------------------------------------------|\n" +
                "    |                                               Combat!                                               |\n");
    }
    private void printCharacters() {
        setCharArray();
        System.out.printf(
                "    |--------------------------------------------------|--------------------------------------------------|\n" +
                "    |                                                  |           %s           |\n" +
                "    |                Me, Myself, and I.                |           %s           |\n" +
                "    |           |------------MMI-----------|           |           %s           |\n" +
                "    |           |                          |           |           %s           |\n" +
                "    |           |                          |           |           %s           |\n" +
                "    |           |                          |           |           %s           |\n" +
                "    |           |                          |           |           %s           |\n" +
                "    |           |                          |           |           %s           |\n" +
                "    |           |                          |           |           %s           |\n" +
                "    |           |                          |           |           %s           |\n" +
                "    |           |                          |           |           %s           |\n" +
                "    |           |                          |           |           %s           |\n" +
                "    |           |--------------------------|           |           %s           |\n" +
                "    |                                                  |           %s           |\n" +
                "    |                 [ENERGY] (%2d/%-2d)                 |           %s           |\n" +
                "    |                [HEALTH] (%3d/%-3d)                |           %s           |\n" +
                "    |                     [      ]                     |           %s           |\n" +
                "    |                                                  |           %s           |\n",
                charArray[0], charArray[1], charArray[2], charArray[3], charArray[4], charArray[5], charArray[6], charArray[7], charArray[8],
                charArray[9], charArray[10], charArray[11], charArray[12], charArray[13], this.player.getMaxEnergy(), this.player.getEnergy(),
                charArray[14], this.player.getHealth(), this.player.getMaxHealth(), charArray[15], charArray[16], charArray[17]);
    }
    private void printActive() {
        System.out.printf(
                "    |--------------------------------------------------|--------------------------------------------------|\n" +
                "    |                                             Active Item                                             |\n" +
                "    |                                                [ACT]                                                |\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |       |                                                                                     |       |\n" +
                "    |       | %s |       |\n" +
                "    |       |                                                                                     |       |\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |                                                                                                     |\n",
                (this.player.hasActiveItem() ? "("+this.player.getActiveItemLongName()+") - "+this.player.getActiveItemEffect()
                        : "                                                                                   "));
    }
    private void printArtifacts() {
        System.out.print(
                "    |-----------------------------------------------------------------------------------------------------|\n" +
                "    |                                              Artifacts                                              |\n" +
                "    |                                                                                                     |\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |       |                                                                                     |       |\n" +
                "    |       |      ");
        for (int i = 0; i < 5; i++)
            System.out.printf("[----%s----]  ", (this.player.hasArtifact(i) ? this.player.getArtifactCode(i) : "---"));
        System.out.print("    |       |\n    |       |      ");
        for (int i = 0; i < 5; i++)
            System.out.printf("| %s |  ", (this.player.hasArtifact(i) ? this.player.getArtifactName(i) : "         "));
        System.out.print("    |       |\n" +
                "    |       |      [-----------]  [-----------]  [-----------]  [-----------]  [-----------]      |       |\n" +
                "    |       |                                                                                     |       |\n" +
                "    |       |      ");
        for (int i = 5; i < 10; i++)
            System.out.printf("[----%s----]  ", (this.player.hasArtifact(i) ? this.player.getArtifactCode(i) : "---"));
        System.out.print("    |       |\n    |       |      ");
        for (int i = 5; i < 10; i++)
            System.out.printf("| %s |  ", (this.player.hasArtifact(i) ? this.player.getArtifactName(i) : "         "));
        System.out.print("    |       |\n" +
                "    |       |      [-----------]  [-----------]  [-----------]  [-----------]  [-----------]      |       |\n" +
                "    |       |                                                                                     |       |\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |                                                                                                     |\n");
    }
    private void printItems() {
        System.out.print(
                "    |-----------------------------------------------------------------------------------------------------|\n" +
                "    |                                                Items                                                |\n" +
                "    |                                                                                                     |\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |       |                                                                                     |       |\n" +
                "    |       |       ");
        for (int i = 0; i < 6; i++)
            System.out.printf("[---%s---] ", (this.player.hasItem(i) ? this.player.getItemCode(i) : "---"));
        System.out.print("      |       |\n    |       |       ");
        for (int i = 0; i < 6; i++)
            System.out.printf("| %s | ", (this.player.hasItem(i) ? this.player.getItemName(i) : "       "));
        System.out.print("      |       |\n    |       |       ");
        for (int i = 0; i < 6; i++)
            System.out.printf("[---%s---] ", (this.player.hasItem(i) ? "("+this.player.getItemEnergyCost(i)+")" : "---"));
        System.out.print("      |       |\n" +
                "    |       |                                                                                     |       |\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |                                                                                                     |\n");
    }
    private void printBottom() {
        System.out.print(
                "    |-----------------------------------------------------------------------------------------------------|\n" +
                "    |                                              End  Turn                                              |\n" +
                "    |                                                [END]                                                |\n" +
                "    |-----------------------------------------------------------------------------------------------------|\n\n");
    }
}

