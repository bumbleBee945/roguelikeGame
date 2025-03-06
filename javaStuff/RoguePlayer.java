public class RoguePlayer {

    //attributes
    private int maxHealth;
    private int health;
    private int maxEnergy;
    private int energy;
    private RogueItem activeItem;
    private RogueItem[] itemInventory = new RogueItem[6];
    private RogueArtifact[] artifactInventory = new RogueArtifact[10];
    private String[] statusArray;

    //constructor
    public RoguePlayer() {
        this.maxHealth = 80;
        this.health = 80;
        this.maxEnergy = 3;
        this.energy = 3;
        initInventory();
    }

    //methods
    public void displayItem(int slot) { this.itemInventory[slot].display(); }
    public void displayArtifact(int slot) { this.artifactInventory[slot].display(); }
    public int findItem(String code2) {
        for (int i = 0; i < 6; i++)
            if ((this.itemInventory[i] != null) && (this.itemInventory[i].getCode().equals(code2)))
                return i;
        return -1;
    }
    public int findArtifact(String code2) {
        System.out.print("Finding artifact "+code2+" / ");
        for (int i = 0; i < 10; i++) {
            System.out.print("For loop " + i + " / ");
            if ((this.artifactInventory[i] != null) && (this.artifactInventory[i].getCode().equals(code2))) {
                System.out.print("Returning i / ");
                return i;
            }
        }
        return -1;
    }

    //accessors
    public int getHealth() { return this.health; }
    public int getMaxHealth() { return this.maxHealth; }
    public int getEnergy() { return this.energy; }
    public int getMaxEnergy() { return this.maxEnergy; }
    public String getActiveItemLongName() { return this.activeItem.getLongName(); }
    public String getActiveItemEffect() { return this.activeItem.getEffect(); }
    public String getItemCode(int slot) { return this.itemInventory[slot].getCode(); }
    public String getItemName(int slot) { return this.itemInventory[slot].getName(); }
    public String getItemLongName(int slot) { return this.itemInventory[slot].getLongName(); }
    public String getItemEffect(int slot) { return this.itemInventory[slot].getEffect(); }
    public int getItemEnergyCost(int slot) { return this.itemInventory[slot].getEnergyCost(); }
    public String getArtifactCode(int slot) { return this.artifactInventory[slot].getCode(); }
    public String getArtifactName(int slot) { return this.artifactInventory[slot].getName(); }
    public String getArtifactLongName(int slot) { return this.artifactInventory[slot].getLongName(); }
    public String getArtifactEffect(int slot) { return this.artifactInventory[slot].getEffect(); }
    public boolean hasItem(int slot) { return (this.itemInventory[slot] != null); }
    public boolean hasActiveItem() { return (this.activeItem != null); }
    public boolean hasArtifact(int slot) { return (this.artifactInventory[slot] != null); }

    //initializers
    private void initInventory() {
        this.activeItem = new RogueItem("POC");
        this.itemInventory[0] = new RogueItem("KNI");
        this.itemInventory[1] = new RogueItem("BOW");
        this.itemInventory[2] = new RogueItem("SAL");
        this.itemInventory[3] = new RogueItem("STI");
        this.itemInventory[4] = new RogueItem("HER");
        this.artifactInventory[0] = new RogueArtifact("MED");
        this.artifactInventory[1] = new RogueArtifact("CLO");
        this.artifactInventory[2] = new RogueArtifact("TOX");
        this.artifactInventory[3] = new RogueArtifact("VIG");
        this.artifactInventory[4] = new RogueArtifact("BER");
        this.artifactInventory[5] = new RogueArtifact("IVN");
        this.artifactInventory[6] = new RogueArtifact("HEA");
    }
}