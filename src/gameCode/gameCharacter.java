package gameCode;

public abstract class gameCharacter {
    //attributes
    private String name;
    private int maxHealth;
    private int health;

    //constructors

    //accessors
    public String getName() { return this.name; }
    public int getMaxHealth() { return this.maxHealth; }
    public int getHealth() { return this.health; }

    //mutators
    public void setName(String name) { this.name = name; }
    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }
    public void setHealth(int health) { this.health = health; }
    public void subHealth(int health) { this.health -= health; }
    public void addHealth(int health) { this.health += health; }

    //methods

    //initializers

    //displays
}
