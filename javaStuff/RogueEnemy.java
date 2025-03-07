public class RogueEnemy {
    //attributes
    private String name;
    private int health;
    private int maxHealth;
    private String intentType;
    private int intentNum;
    private String intentStatus;
    private String intentEffect;
    private String code;

    //constructors
    public RogueEnemy(String code) {
        this.code = code;
        initAttributes();
    }

    //accessors
    public String getName() { return this.name; }
    public String getCode() { return this.code; }
    public int getHealth() { return this.health; }
    public int getMaxHealth() { return this.maxHealth; }
    public String getIntentEffect() { return this.intentEffect; }
    public String getIntentType() { return this.intentType; }
    public int getIntentNum() { return this.intentNum; }

    //methods
    private void setStats(int hp, int max, String name) {
        this.health = hp;
        this.maxHealth = max;
        this.name = name;
    }

    private void setIntent(String type, int num) {
        this.intentType = type;
        this.intentNum = num;
        switch (intentType) {
            case "Attack":
                this.intentEffect = String.format("           This enemy intends to attack for %2d damage.           ", num);
                break;
            case "Block":
                this.intentEffect = String.format("           This enemy intends to block for %2d health.            ", num);
                break;
        }
    }
    private void setIntent(String type, int num, String status) {
        this.intentType = type;
        this.intentNum = num;
        this.intentStatus = status;
        this.intentEffect = String.format("            This enemy intends to apply %d %-11s            ", num, RogueStatus.getStatus(this.intentStatus).getStatusType() + ".");
    }

    private void initAttributes() {
        switch (this.code) {
            case "CUL":
                setStats(40, 40, "     Crazed Cultist     ");
                setIntent("Attack", 7);
                break;
            case "BOO":
                setStats(20, 20, "       Blue  Ooze       ");
                setIntent("Attack", 7);
                break;
            case "GOO":
                setStats(15, 15, "       Green Ooze       ");
                setIntent("Attack", 7);
                break;
        }
    }
    public void display() {
        System.out.printf(
                "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                     \"%s\"                                      |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                    You are displaying an enemy.                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                       To exit, press 'Enter'.                                       |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                             Enemy Name                                              |\n" +
                        "    |                                                                                                     |\n" +
                        "    |       [===================================================================|=================]       |\n" +
                        "    |       |                                                                   |                 |       |\n" +
                        "    |       |                    \"%s\"                     |      [%s]      |       |\n" +
                        "    |       |                                                                   |                 |       |\n" +
                        "    |       [===================================================================|=================]       |\n" +
                        "    |                                                                                                     |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                            Enemy Intent                                             |\n" +
                        "    |                                                                                                     |\n" +
                        "    |       [=====================================================================================]       |\n" +
                        "    |       |                                    (%s * %-2d)                                    |       |\n" +
                        "    |       |                                                                                     |       |\n" +
                        "    |       |                                                                                     |       |\n" +
                        "    |       |                                                                                     |       |\n" +
                        "    |       |          %s          |       |\n" +//65char
                        "    |       |   %s %s  |       |\n" +//4, 75char
                        "    |       |                                                                                     |       |\n" +
                        "    |       |                                                                                     |       |\n" +
                        "    |       |                                                                                     |       |\n" +
                        "    |       [=====================================================================================]       |\n" +
                        "    |                                                                                                     |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                           Enemy Vitality                                            |\n" +
                        "    |                                                                                                     |\n" +
                        "    |       [==================================|==================================================]       |\n" +
                        "    |       |              Health              |                     Statuses                     |       |\n" +
                        "    |       |                                  |                                                  |       |\n" +
                        "    |       |          [HP] (%3d/%-3d)          |                     [      ]                     |       |\n" +
                        "    |       |                                  |                                                  |       |\n" +
                        "    |       |                                  |                                                  |       |\n" +
                        "    |       [==================================|==================================================]       |\n" +
                        "    |                                                                                                     |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                                Exit:                                                |\n" +
                        "    |                                               [Enter]                                               |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|",
                this.name, this.name, this.code, this.intentType, this.intentNum, this.intentEffect,
                (this.intentType.equals("status") ? RogueStatus.getStatus(this.intentStatus).getStatusCode()+":" : "    "),
                (this.intentType.equals("status") ? RogueStatus.getStatus(this.intentStatus).getStatusDescription() : "                                                                 "),
                this.health, this.maxHealth);
    }
}