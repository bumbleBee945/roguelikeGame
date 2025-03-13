package gameCode;

public abstract class gamePickup {
    //attributes
    private String tier;
    private String longName;
    private String name;
    private String effect;
    private String code;
    private int cost;
    private boolean glitched;

    //constructors

    //accessors
    public boolean isNull() { return this.name.equals("null"); }
    public String getTier() { return this.tier; }
    public String getName() { return this.name; }
    public String getLongName() { return this.longName; }
    public String getEffect() { return this.effect; }
    public String getCode() { return this.code; }
    public int getCost() { return this.cost; }
    public boolean isGlitched() { return this.glitched; }

    //mutators
    public void setNull() { this.name = "null"; }
    public void setTier(String tier) { this.tier = tier; }
    public void setName(String name) { this.name = name; }
    public void setLongName(String longName) { this.longName = longName; }
    public void setEffect(String effect) { this.effect = effect; }
    public void setCode(String code) { this.code = code; }
    public void setCost(int cost) { this.cost = cost; }
    public void setGlitched(boolean glitched) { this.glitched = glitched; }

    //methods

    //initializers
    public abstract void initialize();

    //displays
    public void display() {
        System.out.println("display");
    }
}
