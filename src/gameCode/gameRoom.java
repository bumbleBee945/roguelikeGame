package gameCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static gameCode.gameMain.random;

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
    public boolean isNull() { return type.equals("null"); }
    public String getName() { return name; }
    public String getType() { return type; }
    public int getEnemyCount() { return enemy.size(); }
    public String getEnemy(int index) { return enemy.get(index); }

    //mutators
    public void setNull() { this.type = "null"; }
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }

    //methods
    private void randomEncounter() {
        Scanner reader;
        String next = "";
        //set scanner for encounterList.txt
        try {
            if (type.equals("enemy"))
                reader = new Scanner(new File("resources/encounterListEnemy.txt"));
            else if (type.equals("brute"))
                reader = new Scanner(new File("resources/encounterListEnemy.txt"));
            else
                reader = new Scanner(new File("resources/encounterListEnemy.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int num = random(1, 4);
        for (int i = 0; i < num; i++)
            next = reader.nextLine();
        for (String e : next.split(", "))
            enemy.add(e);
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
                randomEncounter();
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
                randomEncounter();
                break;
        }
        if (name.isEmpty())
            setNull();
    }

    //displays
}
