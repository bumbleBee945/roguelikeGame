public class RoguePlayer {

    //attributes
    private int maxHealth;
    private int Health;
    private RogueItem[] itemInventory = new RogueItem[6];
    private RogueArtifact[] artifactInventory = new RogueArtifact[10];
    private String[] statusArray = new String[];

    //constructor
    public RoguePlayer() {
        this.maxHealth = 80;
        this.Health = 80;
        initInventory();
    }

    //methods
    private void initInventory() {
        this.itemInventory[0] = new RogueItem("KNI");
        this.itemInventory[1] = new RogueItem("BOW");
        this.itemInventory[2] = new RogueItem("BUC");
        this.itemInventory[3] = new RogueItem("STI");
        this.itemInventory[4] = new RogueItem("HER");
        this.artifactInventory[0] = new RogueArtifact("");
        this.artifactInventory[1] = new RogueArtifact("");
        this.artifactInventory[2] = new RogueArtifact("");
        this.artifactInventory[3] = new RogueArtifact("");
        this.artifactInventory[4] = new RogueArtifact("");
        this.artifactInventory[5] = new RogueArtifact("");
        this.artifactInventory[6] = new RogueArtifact("");
    }
}