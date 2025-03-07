public class RoguePickup {
    //attributes
    protected String tier;
    protected String longName;
    protected String name;
    protected String effect;
    protected String code;
    protected int goldCost;
    protected int energyCost;
    protected boolean glitched;

    //accessors
    public String getCode() { return this.code; }
    public String getLongName() { return this.longName; }
    public String getName() { return this.name; }
    public String getEffect() { return this.effect; }

    //methods
    public void display() { //defaults to artifact
        String displayString = "You are displaying an artifact.";
        String nameString = "Artifact Name";
        String effectString = "Artifact Effect";
        String shortName = this.name;
        String energyString = "          ";
        String tierString = "[Base]      Good       Great ";
        if (this instanceof RogueItem) { //if item
            displayString = "  You are displaying an item.  ";
            nameString = "  Item Name  ";
            shortName = String.format(" %s ", shortName);
            effectString = "  Item Effect  ";
            energyString = String.format("(%d) Energy", ((RogueItem)this).getEnergyCost());
        }
        switch (this.tier) {
            case "good": tierString = " Base      [Good]      Great "; break;
            case "great": tierString = " Base       Good      [Great]"; break;
        }
        System.out.printf("\n\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                           %s                                           |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                                                                                     |\n" +
                        "    |                                   %s                                   |\n" +//31
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
                        "    |                                            %s                                            |\n" +
                        "    |                                                                                                     |\n" +
                        "    |       [=======================================|===========================|=================]       |\n" +
                        "    |       |                                       |                           |                 |       |\n" +
                        "    |       |           \"%s\"           |        \"%s\"        |      [%s]      |       |\n" +
                        "    |       |                                       |                           |                 |       |\n" +
                        "    |       [=======================================|===========================|=================]       |\n" +
                        "    |                                                                                                     |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                           %s                                           |\n" +
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
                        "    |       |                %s                |                                          |       |\n" +
                        "    |       |                                          |                                          |       |\n" +
                        "    |       [=====================================================================================]       |\n" +
                        "    |                                                                                                     |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n" +
                        "    |                                                Exit:                                                |\n" +
                        "    |                                               [Enter]                                               |\n" +
                        "    |-----------------------------------------------------------------------------------------------------|\n\n",
                this.longName, displayString, nameString, this.longName, shortName, this.code, effectString,
                this.longName, this.effect, this.goldCost, tierString, energyString);
    }
}