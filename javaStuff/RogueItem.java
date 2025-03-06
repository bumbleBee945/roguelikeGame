public class RogueItem {

    //attributes
    private String tier;
    private String longName;
    private String name;
    private String code;
    private int goldCost;
    private int energyCost;
    private boolean upgraded;
    private boolean glitched;
    private String modifier;

    //constructor
    public RogueItem(String code) {
        this.code = code;
        setAttributes(code);
    }

    //methods
    private void setAttributes(String code) {
        switch (code) {
            case "STO":
                this.tier = "base";
                this.longName = "Small Stone";
                this.name = "Stone";
                this.goldCost = 35;
                this.energyCost = -1;
            case "PEA":
                this.tier = "base";
                this.longName = "Gold Peach";
                this.name = "Peach";
                this.goldCost = 35;
                this.energyCost = -1;
            case "KNI":
                this.tier = "base";
                this.longName = "Crude Knife";
                this.name = "Knife";
                this.goldCost = 15;
                this.energyCost = 1;
            case "SAL":
                this.tier = "base";
                this.longName = "Healing Salve";
                this.name = "Salve";
                this.goldCost = 35;
                this.energyCost = 2;
            case "BOU":
                this.tier = "base";
                this.longName = "Cool Boulder";
                this.name = "Boulder";
                this.goldCost = 25;
                this.energyCost = 2;
            case "TOR":
                this.tier = "base";
                this.longName = "Torch";
                this.name = "Torch";
                this.goldCost = 40;
                this.energyCost = 2;
            case "HER":
                this.tier = "base";
                this.longName = "Cleansing Herbs";
                this.name = "Herbs";
                this.goldCost = 30;
                this.energyCost = 1;
            case "TON":
                this.tier = "base";
                this.longName = "Cherry Tonic";
                this.name = "Tonic";
                this.goldCost = 20;
                this.energyCost = 2;
            case "STI":
                this.tier = "base";
                this.longName = "Sticky Bomb";
                this.name = "S. Bomb";
                this.goldCost = 40;
                this.energyCost = 2;
            case "RAT":
                this.tier = "base";
                this.longName = "Rat Tooth";
                this.name = "Tooth";
                this.goldCost = 25;
                this.energyCost = 1;
            case "BOW":
                this.tier = "base";
                this.longName = "Longbow";
                this.name = "Longbow";
                this.goldCost = 25;
                this.energyCost = 1;
            case "BUC":
                this.tier = "base";
                this.longName = "Rusty Buckler";
                this.name = "Buckler";
                this.goldCost = 20;
                this.energyCost = 1;
            /*case "":
                this.tier = "";
                this.longName = "";
                this.goldCost = ;
                this.energyCost = ;*/
        }
    }
}