package gameCode;

public abstract class gameCharacter {
    //attributes
    private String name;
    private int maxHealth;
    private int health;

    //constructors

    //accessors
    public String getName() { return name; }
    public int getMaxHealth() { return maxHealth; }
    public int getHealth() { return health; }

    //mutators
    public void setName(String name) { this.name = name; }
    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }
    public void setHealth(int health) { this.health = health; }
    public void subHealth(int health) {
        this.health -= health;
        if (this.health < 0)
            this.health = 0;
    }
    public void addHealth(int health) {
        this.health += health;
        if (this.health > maxHealth)
            this.health = maxHealth;
    }

    //methods

    //initializers

    //displays
}
