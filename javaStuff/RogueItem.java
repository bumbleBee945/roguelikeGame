public class RogueItem extends RoguePickup {

    //attributes
    private int energyCost;
    private boolean upgraded;
    private String modifier;

    //constructor
    public RogueItem(String code) {
        this.code = code;
        setAttributes();
    }

    //accessors
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
                this.effect = "              Remove one negative status effect.               ";
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
}