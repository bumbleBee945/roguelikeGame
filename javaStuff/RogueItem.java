public class RogueItem {

    //attributes
    private String tier;
    private String longName;
    private String name;
    private String effect;
    private String code;
    private int goldCost;
    private int energyCost;
    private boolean upgraded;
    private boolean glitched;
    private String modifier;

    //constructor
    public RogueItem(String code) {
        this.code = code;
        setAttributes();
    }

    //accessors
    public String getCode() { return this.code; }
    public String getLongName() { return this.longName; }
    public String getName() { return this.name; }
    public String getEffect() { return this.effect; }
    public int getEnergyCost() { return this.energyCost; }

    //methods
    private void setAttributes() {
        switch (this.code) {
            case "STO":
                this.tier = "base";
                this.longName = "  Small Stone  ";
                this.name = " Stone ";
                this.effect = "                                                               ";
                this.goldCost = 40;
                this.energyCost = -1;
                break;
            case "PEA":
                this.tier = "base";
                this.longName = "  Gold  Peach  ";
                this.name = " Peach ";
                this.effect = "                                                               ";
                this.goldCost = 40;
                this.energyCost = -1;
            case "KNI":
                this.tier = "base";
                this.longName = "  Crude Knife  ";
                this.name = " Knife ";
                this.effect = "                                                               ";
                this.goldCost = 25;
                this.energyCost = 1;
                break;
            case "SAL":
                this.tier = "base";
                this.longName = " Healing Salve ";
                this.name = " Salve ";
                this.effect = "                                                               ";
                this.goldCost = 25;
                this.energyCost = 2;
                break;
            case "BOU":
                this.tier = "base";
                this.longName = " Cool  Boulder ";
                this.name = "Boulder";
                this.effect = "                                                               ";
                this.goldCost = 25;
                this.energyCost = 2;
                break;
            case "TOR":
                this.tier = "base";
                this.longName = "Torch";
                this.name = " Torch ";
                this.effect = "                                                               ";
                this.goldCost = 25;
                this.energyCost = 2;
                break;
            case "HER":
                this.tier = "base";
                this.longName = "Cleansing Herbs";
                this.name = " Herbs ";
                this.effect = "                                                               ";
                this.goldCost = 25;
                this.energyCost = 1;
                break;
            case "TON":
                this.tier = "base";
                this.longName = " Cherry  Tonic ";
                this.name = " Tonic ";
                this.effect = "                                                               ";
                this.goldCost = 25;
                this.energyCost = 2;
                break;
            case "STI":
                this.tier = "base";
                this.longName = "  Sticky Bomb  ";
                this.name = "S. Bomb";
                this.effect = "                                                               ";
                this.goldCost = 25;
                this.energyCost = 2;
                break;
            case "RAT":
                this.tier = "base";
                this.longName = "   Rat Tooth   ";
                this.name = " Tooth ";
                this.effect = "                                                               ";
                this.goldCost = 25;
                this.energyCost = 1;
                break;
            case "BOW":
                this.tier = "base";
                this.longName = "    Longbow    ";
                this.name = "Longbow";
                this.effect = "                                                               ";
                this.goldCost = 25;
                this.energyCost = 1;
                break;
            case "BUC":
                this.tier = "base";
                this.longName = " Rusty Buckler ";
                this.name = "Buckler";
                this.effect = "                                                               ";
                this.goldCost = 25;
                this.energyCost = 1;
                break;
            case "POC":
                this.tier = "good";
                this.longName = "  Pocket Sand  ";
                this.effect = "Temporarily blind an enemy, causing their next attack to miss. ";
                this.goldCost = 70;
                break;
            /*case "":
                this.tier = "";
                this.longName = "";
                this.name = "";
                this.goldCost = ;
                this.energyCost = ;
                break;*/
        }
    }
    public void display() {
        System.out.printf("\n\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                           %s                                           |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                     You are displaying an item.                                     |\n" +
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
                        "    |                                              Item Name                                              |\n" +
                        "    |                                                                                                     |\n" +
                        "    |       [=======================================|===========================|=================]       |\n" +
                        "    |       |                                       |                           |                 |       |\n" +
                        "    |       |           \"%s\"           |        \"%s\"        |      [%s]      |       |\n" +
                        "    |       |                                       |                           |                 |       |\n" +
                        "    |       [=======================================|===========================|=================]       |\n" +
                        "    |                                                                                                     |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                           Artifact Effect                                           |\n" +
                        "    |                                                                                                     |\n" +
                        "    |       [=====================================================================================]       |\n" +
                        "    |       |                                   %s                                   |       |\n" +
                        "    |       |                                                                                     |       |\n" +
                        "    |       |                                                                                     |       |\n" +
                        "    |       |                                                                                     |       |\n" +
                        "    |       |           %s           |       |\n" +//63 char
                        "    |       |                                                                                     |       |\n" +
                        "    |       |                                                                                     |       |\n" +
                        "    |       |                                                                                     |       |\n" +
                        "    |       |                                                                                     |       |\n" +
                        "    |       [=====================================================================================]       |\n" +
                        "    |                                                                                                     |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                                Specs                                                |\n" +
                        "    |                                                                                                     |\n" +
                        "    |       [==========================================|==========================================]       |\n" +
                        "    |       |                   Cost                   |                  Rarity                  |       |\n" +
                        "    |       |                                          |                                          |       |\n" +
                        "    |       |                   %3dg                   |       %s      |       |\n" +
                        "    |       |                                          |                                          |       |\n" +
                        "    |       |                                          |                                          |       |\n" +
                        "    |       [=====================================================================================]       |\n" +
                        "    |                                                                                                     |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                                Exit:                                                |\n" +
                        "    |                                               [Enter]                                               |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n\n",
                this.longName, this.longName, this.name, this.code, this.longName, this.effect, this.goldCost,
                (this.tier.equals("base") ? "[Base]      Good       Great " :
                        (this.tier.equals("good") ? " Base      [Good]      Great " : " Base       Good      [Great]")));
    }
}