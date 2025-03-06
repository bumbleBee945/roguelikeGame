public class RogueArtifact {

    //attributes
    private String tier;
    private String longName;
    private String name;
    private String effect;
    private String code;
    private int goldCost;
    private boolean glitched;

    //constructor
    public RogueArtifact(String code) {
        this.code = code;
        setAttributes(code);
    }

    //accessors
    public String getCode() { return this.code; }
    public String getLongName() { return this.longName; }
    public String getName() { return this.name; }
    public String getEffect() { return this.effect; }

    //methods
    private void setAttributes(String code) {
        switch (code) {
            case "MED":
                this.tier = "base";
                this.longName = " Rusted  Medal ";
                this.name = " R.Medal ";
                this.goldCost = 40;
                break;
            case "CLO":
                this.tier = "base";
                this.longName = "Tattered  Cloak";
                this.name = " T.Cloak ";
                this.goldCost = 40;
                break;
            case "TOX":
                this.tier = "base";
                this.longName = "  Toxic  Fang  ";
                this.name = " T. Fang ";
                this.goldCost = 40;
                break;
            case "VIG":
                this.tier = "base";
                this.longName = "  Vigor Charm  ";
                this.name = " V.Charm ";
                this.goldCost = 40;
                break;
            case "BER":
                this.tier = "base";
                this.longName = "Berserker  Brew";
                this.name = " B. Brew ";
                this.goldCost = 40;
                break;
            case "IVN":
                this.tier = "base";
                this.longName = "   IV Needle   ";
                this.name = "IV Needle";
                this.goldCost = 40;
                break;
            case "SWI":
                this.tier = "base";
                this.longName = "  Swift Shoes  ";
                this.name = " S.Shoes ";
                this.goldCost = 40;
                break;
            case "HAR":
                this.tier = "base";
                this.longName = "Hardened  Shell";
                this.name = " H.Shell ";
                this.goldCost = 40;
                break;
            case "COI":
                this.tier = "base";
                this.longName = " Phantom  Coin ";
                this.name = " P. Coin ";
                this.goldCost = 40;
                break;
            case "SPI":
                this.tier = "base";
                this.longName = "Spiked Shoulder";
                this.name = "S.Shoulder";
                this.goldCost = 40;
                break;
            case "HEA":
                this.tier = "good";
                this.longName = " Heart-beater  ";
                this.name = " Heart-B ";
                this.goldCost = 85;
                break;
            case "BLA":
                this.tier = "good";
                this.longName = " Blaze  Burner ";
                this.name = "B. Burner";
                this.goldCost = 85;
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