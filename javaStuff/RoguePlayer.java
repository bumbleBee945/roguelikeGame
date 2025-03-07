import java.util.ArrayList;

public class RoguePlayer {

    //attributes
    private int maxHealth;
    private int health;
    private int maxEnergy;
    private int energy;
    private RogueItem activeItem;
    private ArrayList<RogueItem> itemInventory = new ArrayList<>();
    private ArrayList<RogueArtifact> artifactInventory = new ArrayList<>();
    private ArrayList<RogueStatus> statusList = new ArrayList<>();

    //constructor
    public RoguePlayer() {
        this.maxHealth = 80;
        this.health = 80;
        this.maxEnergy = 3;
        this.energy = 3;
        initInventory();
    }

    //methods
    public void displayItem(int slot) { this.itemInventory.get(slot).display(); }
    public void displayArtifact(int slot) { this.artifactInventory.get(slot).display(); }
    public int findItem(String code2) {
        for (int i = 0; i < itemInventory.size(); i++)
            if ((this.itemInventory.get(i) != null) && (this.itemInventory.get(i).getCode().equals(code2)))
                return i;
        return -1;
    }
    public int findArtifact(String code2) {
        for (int i = 0; i < artifactInventory.size(); i++)
            if ((this.artifactInventory.get(i) != null) && (this.artifactInventory.get(i).getCode().equals(code2)))
                return i;
        return -1;
    }

    //accessors
    public int getHealth() { return this.health; }
    public int getMaxHealth() { return this.maxHealth; }
    public int getEnergy() { return this.energy; }
    public int getMaxEnergy() { return this.maxEnergy; }
    public String getActiveItemLongName() { return this.activeItem.getLongName(); }
    public String getActiveItemEffect() { return this.activeItem.getEffect(); }
    public String getItemCode(int slot) { return this.itemInventory.get(slot).getCode(); }
    public String getItemName(int slot) { return this.itemInventory.get(slot).getName(); }
    public String getItemLongName(int slot) { return this.itemInventory.get(slot).getLongName(); }
    public String getItemEffect(int slot) { return this.itemInventory.get(slot).getEffect(); }
    public int getItemEnergyCost(int slot) { return this.itemInventory.get(slot).getEnergyCost(); }
    public String getArtifactCode(int slot) { return this.artifactInventory.get(slot).getCode(); }
    public String getArtifactName(int slot) { return this.artifactInventory.get(slot).getName(); }
    public String getArtifactLongName(int slot) { return this.artifactInventory.get(slot).getLongName(); }
    public String getArtifactEffect(int slot) { return this.artifactInventory.get(slot).getEffect(); }
    public boolean hasItem(int slot) { return (this.itemInventory.size() > slot); }
    public boolean hasActiveItem() { return (this.activeItem != null); }
    public boolean hasArtifact(int slot) { return (this.artifactInventory.size() > slot); }

    //mutators

    //initializers
    private void initInventory() {
        this.activeItem = new RogueItem("POC");
        this.itemInventory.add(new RogueItem("KNI"));
        this.itemInventory.add(new RogueItem("BOW"));
        this.itemInventory.add(new RogueItem("SAL"));
        this.itemInventory.add(new RogueItem("STI"));
        this.itemInventory.add(new RogueItem("HER"));
        this.artifactInventory.add(new RogueArtifact("MED"));
        this.artifactInventory.add(new RogueArtifact("CLO"));
        this.artifactInventory.add(new RogueArtifact("TOX"));
        this.artifactInventory.add(new RogueArtifact("VIG"));
        this.artifactInventory.add(new RogueArtifact("BER"));
        this.artifactInventory.add(new RogueArtifact("IVN"));
        this.artifactInventory.add(new RogueArtifact("HEA"));
        this.statusList.add(new RogueStatus(RogueStatus.getStatus("VUL"), 4));
        this.statusList.add(new RogueStatus(RogueStatus.getStatus("STR"), 2));
    }

    //methods
    public void display() {
        String[] tempArray = new String[8];
        for (int i = 0; i < 8; i++)
            tempArray[i] = "                                                    |       |\n" +
                    "    |       |                                                                                     |       |";
        for (int i = 0; i < statusList.size(); i++)
            tempArray[i] = String.format("%10s (%d)                                      |       |\n    |       |   %s: %s  |       |",
                statusList.get(i).getStatusType(), statusList.get(i).getStatusNum(), statusList.get(i).getStatusCode(), statusList.get(i).getStatusDescription());
        System.out.printf("\n\n" +
                "    |-----------------------------------------------------------------------------------------------------|\n" +
                "    |                                           Player Statuses                                           |\n" +
                "    |-----------------------------------------------------------------------------------------------------|\n" +
                "    |                                                                                                     |\n" +
                "    |                                                                                                     |\n" +
                "    |                                                                                                     |\n" +
                "    |                                                                                                     |\n" +
                "    |                                                                                                     |\n" +
                "    |                              You are displaying your current statuses.                              |\n" +
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
                "    |                                         Status Effect List                                          |\n" +
                "    |                                                                                                     |\n" +
                "    |                                                                                                     |\n" +
                "    |                                                                                                     |\n" +
                "    |                                                                                                     |\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |       |                                 %s\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |       |                                 %s\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |       |                                 %s\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |       |                                 %s\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |       |                                 %s\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |       |                                 %s\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |       |                                 %s\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |       |                                 %s\n" +
                "    |       [=====================================================================================]       |\n" +
                "    |                                                                                                     |\n" +
                "    |                                                                                                     |\n" +
                "    |                                                                                                     |\n" +
                "    |                                                                                                     |\n" +
                "    |-----------------------------------------------------------------------------------------------------|\n" +
                "    |                                                Exit:                                                |\n" +
                "    |                                               [Enter]                                               |\n" +
                "    |-----------------------------------------------------------------------------------------------------|\n\n",
                tempArray[0], tempArray[1], tempArray[2], tempArray[3], tempArray[4], tempArray[5], tempArray[6], tempArray[7]);
    }
}