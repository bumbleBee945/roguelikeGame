public class RogueCombat {
    //attributes
    private int enemyCount;
    private int round;
    private int turn;
    private String[] charArray = new String[18];
    private RogueEnemy[] enemy = new RogueEnemy[3];

    //constructors
    public RogueCombat(String combatID, RoguePlayer player) {
        initCombat(combatID);
        printGUI(player);
    }

    //methods
    private void initCombat(String combatID) {
        this.round = 1;
        this.turn = 0;
        switch (combatID) {
            case "crazedCultist":
                this.enemyCount = 1;
                enemy[0] = new RogueEnemy("CUL");
                break;
            case "oozes":
                this.enemyCount = 2;
                enemy[0] = new RogueEnemy("GOO");
                enemy[1] = new RogueEnemy("BOO");
                break;
        }
    }

    private void printGUI(RoguePlayer player) {
        printTop();
        printCharacters(player);
        printActive(player);
        printArtifacts(player);
        printItems(player);
        printBottom();
    }

    private void setCharArray() {
        for (int i = 0; i < 18; i++)
            charArray[i] = "                            ";
        switch (this.enemyCount) {
            case 1:
                setCharArrayStrings(5, 3);
                break;
            case 2:
                setCharArrayStrings(1, 1);
                break;
            case 3:
                setCharArrayStrings(0, 0);
                break;
        }
    }
    private void setCharArrayStrings(int start, int plus) {
        for (int j = start, i = 0; i < enemyCount; i++) {
            charArray[j++] = "|--------------------------|";
            charArray[j++] = String.format("| %s |", enemy[i].getName()); //24 char
            charArray[j++] = "|--------------------------|";
            j += plus;
            charArray[j++] = String.format("   [INTENT] (%s)   ", enemy[i].getIntentEffect());
            charArray[j++] = String.format("     [HEALTH] (%3d/%-3d)     ", enemy[i].getHealth(), enemy[i].getMaxHealth());
            charArray[j] = "          [      ]          ";
            j += (plus + plus + plus);
        }
    }

    private void printTop() {
        System.out.print("\n\n" +
                "    |-----------------------------------------------------------------------------------------------------|\n" +
                "    |                                               Combat!                                               |\n");
    }
    private void printCharacters(RoguePlayer player) {
        setCharArray();
        System.out.printf(
                "    |--------------------------------------------------|--------------------------------------------------|\n" +
                "    |                                                  |           %s           |\n" +
                "    |                Me, Myself, and I.                |           %s           |\n" +
                "    |           |--------------------------|           |           %s           |\n" +
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
                charArray[9], charArray[10], charArray[11], charArray[12], charArray[13], player.getMaxEnergy(), player.getEnergy(),
                charArray[14], player.getHealth(), player.getMaxHealth(), charArray[15], charArray[16], charArray[17]);
    }
    private void printActive(RoguePlayer player) {
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
                (player.hasActiveItem() ? "("+player.getActiveItemLongName()+") - "+player.getActiveItemEffect()
                        : "                                                                                   "));
    }
    private void printArtifacts(RoguePlayer player) {
        System.out.print(
                "    |-----------------------------------------------------------------------------------------------------|\n" +
                "    |                                              Artifacts                                              |\n" +
                "    |                                                                                                     |\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |       |                                                                                     |       |\n" +
                "    |       |      ");
        for (int i = 0; i < 5; i++)
            System.out.printf("[----%s----]  ", (player.hasArtifact(i) ? player.getArtifactCode(i) : "---"));
        System.out.print("    |       |\n    |       |      ");
        for (int i = 0; i < 5; i++)
            System.out.printf("| %s |  ", (player.hasArtifact(i) ? player.getArtifactName(i) : "         "));
        System.out.print("    |       |\n" +
                "    |       |      [-----------]  [-----------]  [-----------]  [-----------]  [-----------]      |       |\n" +
                "    |       |                                                                                     |       |\n" +
                "    |       |      ");
        for (int i = 5; i < 10; i++)
            System.out.printf("[----%s----]  ", (player.hasArtifact(i) ? player.getArtifactCode(i) : "---"));
        System.out.print("    |       |\n    |       |      ");
        for (int i = 5; i < 10; i++)
            System.out.printf("| %s |  ", (player.hasArtifact(i) ? player.getArtifactName(i) : "         "));
        System.out.print("    |       |\n" +
                "    |       |      [-----------]  [-----------]  [-----------]  [-----------]  [-----------]      |       |\n" +
                "    |       |                                                                                     |       |\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |                                                                                                     |\n");
    }
    private void printItems(RoguePlayer player) {
        System.out.print(
                "    |-----------------------------------------------------------------------------------------------------|\n" +
                "    |                                                Items                                                |\n" +
                "    |                                                                                                     |\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |       |                                                                                     |       |\n" +
                "    |       |       ");
        for (int i = 0; i < 6; i++)
            System.out.printf("[---%s---] ", (player.hasItem(i) ? player.getItemCode(i) : "---"));
        System.out.print("      |       |\n    |       |       ");
        for (int i = 0; i < 6; i++)
            System.out.printf("| %s | ", (player.hasItem(i) ? player.getItemName(i) : "       "));
        System.out.print("      |       |\n    |       |       ");
        for (int i = 0; i < 6; i++)
            System.out.printf("[---%s---] ", (player.hasItem(i) ? "("+player.getItemEnergyCost(i)+")" : "---"));
        System.out.print("      |       |\n" +
                "    |       |                                                                                     |       |\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |                                                                                                     |\n");
    }
    private static void printBottom() {
        System.out.print(
                "    |-----------------------------------------------------------------------------------------------------|\n" +
                "    |                                              End  Turn                                              |\n" +
                "    |                                                [END]                                                |\n" +
                "    |-----------------------------------------------------------------------------------------------------|\n\n");
    }
}

class RogueEnemy {
    //attributes
    private String name;
    private int health;
    private int maxHealth;
    private String intent;
    private String intentEffect;
    private String code;

    //constructors
    public RogueEnemy(String code) {
        this.code = code;
        setAttributes();
    }

    //accessors
    public String getName() { return this.name; }
    public int getHealth() { return this.health; }
    public int getMaxHealth() { return this.maxHealth; }
    public String getIntentEffect() { return this.intentEffect; }

    //methods
    private void setAttributes() {
        switch (this.code) {
            case "CUL":
                this.name = "     Crazed Cultist     ";
                this.health = 40;
                this.maxHealth = 40;
                this.intentEffect = "Attack * 7 ";
                break;
            case "BOO":
                this.name = "       Blue  Ooze       ";
                this.health = 20;
                this.maxHealth = 20;
                this.intentEffect = "Attack * 7 ";
                break;
            case "GOO":
                this.name = "       Green Ooze       ";
                this.health = 15;
                this.maxHealth = 15;
                this.intentEffect = "Attack * 7 ";
                break;
        }
    }
}