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
                this.goldCost = 40;
                this.energyCost = -1;
                break;
            case "PEA":
                this.tier = "base";
                this.longName = "  Gold  Peach  ";
                this.name = " Peach ";
                this.goldCost = 40;
                this.energyCost = -1;
            case "KNI":
                this.tier = "base";
                this.longName = "  Crude Knife  ";
                this.name = " Knife ";
                this.goldCost = 25;
                this.energyCost = 1;
                break;
            case "SAL":
                this.tier = "base";
                this.longName = " Healing Salve ";
                this.name = " Salve ";
                this.goldCost = 25;
                this.energyCost = 2;
                break;
            case "BOU":
                this.tier = "base";
                this.longName = " Cool  Boulder ";
                this.name = "Boulder";
                this.goldCost = 25;
                this.energyCost = 2;
                break;
            case "TOR":
                this.tier = "base";
                this.longName = "Torch";
                this.name = " Torch ";
                this.goldCost = 25;
                this.energyCost = 2;
                break;
            case "HER":
                this.tier = "base";
                this.longName = "Cleansing Herbs";
                this.name = " Herbs ";
                this.goldCost = 25;
                this.energyCost = 1;
                break;
            case "TON":
                this.tier = "base";
                this.longName = " Cherry  Tonic ";
                this.name = " Tonic ";
                this.goldCost = 25;
                this.energyCost = 2;
                break;
            case "STI":
                this.tier = "base";
                this.longName = "  Sticky Bomb  ";
                this.name = "S. Bomb";
                this.goldCost = 25;
                this.energyCost = 2;
                break;
            case "RAT":
                this.tier = "base";
                this.longName = "   Rat Tooth   ";
                this.name = " Tooth ";
                this.goldCost = 25;
                this.energyCost = 1;
                break;
            case "BOW":
                this.tier = "base";
                this.longName = "    Longbow    ";
                this.name = "Longbow";
                this.goldCost = 25;
                this.energyCost = 1;
                break;
            case "BUC":
                this.tier = "base";
                this.longName = " Rusty Buckler ";
                this.name = "Buckler";
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
}