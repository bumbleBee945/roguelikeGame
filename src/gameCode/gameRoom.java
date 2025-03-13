package gameCode;

import java.util.ArrayList;
import java.util.Arrays;

public class gameRoom {
    //attributes
    private ArrayList<String> enemy = new ArrayList<>();
    private String name;
    private String type;
    private final static ArrayList<String> types = new ArrayList<>(Arrays.asList(
            "enemy", "unknown", "brute", "cache", "store", "error", "bossA"
    ));

    //constructors
    public gameRoom() { setNull(); }
    public gameRoom(String type) {
        setType(type);
        initialize();
    }

    //accessors
    public boolean isNull() { return this.type.equals("null"); }
    public String getName() { return this.name; }
    public String getType() { return this.type; }
    public int getEnemyCount() { return this.enemy.size(); }
    public String getEnemy(int index) { return this.enemy.get(index); }

    //mutators
    public void setNull() { this.type = "null"; }
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }

    //methods
    private void randomEncounter() {
        enemy.add("BOO");
        enemy.add("GOO");
    }

    //initializers
    private void initialize() {
        setName("");
        switch (type) {
            case "enemy":
                setName("   Enemy   ");
                randomEncounter();
                break;
            case "unknown":
                setName("  Unknown  ");
                break;
            case "brute":
                setName("   Brute   ");
                break;
            case "cache":
                setName("   Cache   ");
                break;
            case "store":
                setName("   Store   ");
                break;
            case "error":
                setName(" ???#?$!?? ");
                break;
            case "bossA":
                setName("  Boss  A  ");
                break;
        }
        if (name.isEmpty())
            setNull();
    }

    //displays
}
