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
                this.effect = "                                                               ";
                this.goldCost = 40;
                break;
            case "CLO":
                this.tier = "base";
                this.longName = "Tattered  Cloak";
                this.name = " T.Cloak ";
                this.effect = "                                                               ";
                this.goldCost = 40;
                break;
            case "TOX":
                this.tier = "base";
                this.longName = "  Toxic  Fang  ";
                this.name = " T. Fang ";
                this.effect = "                                                               ";
                this.goldCost = 40;
                break;
            case "VIG":
                this.tier = "base";
                this.longName = "  Vigor Charm  ";
                this.name = " V.Charm ";
                this.effect = "                                                               ";
                this.goldCost = 40;
                break;
            case "BER":
                this.tier = "base";
                this.longName = "Berserker  Brew";
                this.name = " B. Brew ";
                this.effect = "                                                               ";
                this.goldCost = 40;
                break;
            case "IVN":
                this.tier = "base";
                this.longName = "   IV Needle   ";
                this.name = "IV Needle";
                this.effect = "            Heal 1 health upon defeating any enemy.            ";
                this.goldCost = 40;
                break;
            case "SWI":
                this.tier = "base";
                this.longName = "  Swift Shoes  ";
                this.name = " S.Shoes ";
                this.effect = "                                                               ";
                this.goldCost = 40;
                break;
            case "HAR":
                this.tier = "base";
                this.longName = "Hardened  Shell";
                this.name = " H.Shell ";
                this.effect = "                                                               ";
                this.goldCost = 40;
                break;
            case "COI":
                this.tier = "base";
                this.longName = " Phantom  Coin ";
                this.name = " P. Coin ";
                this.effect = "                                                               ";
                this.goldCost = 40;
                break;
            case "SPI":
                this.tier = "base";
                this.longName = "Spiked Shoulder";
                this.name = "S.Shoulder";
                this.effect = "                                                               ";
                this.goldCost = 40;
                break;
            case "HEA":
                this.tier = "good";
                this.longName = " Heart-beater  ";
                this.name = " Heart-B ";
                this.effect = "                                                               ";
                this.goldCost = 85;
                break;
            case "BLA":
                this.tier = "good";
                this.longName = " Blaze  Burner ";
                this.name = "B. Burner";
                this.effect = "                                                               ";
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
                "    |                                   You are displaying an artifact.                                   |\n" +
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
                "    |                                            Artifact Name                                            |\n" +
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