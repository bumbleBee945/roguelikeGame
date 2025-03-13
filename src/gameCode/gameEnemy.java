package gameCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class gameEnemy extends gameCharacter {
    //attributes
    private String code;
    private ArrayList<String> move = new ArrayList<>();
    private String intentString = "";

    //constructors
    public gameEnemy() { setNull(); }
    public gameEnemy(String code) {
        setCode(code);
        initialize();
    }

    //accessors
    public String getCode() { return this.code; }

    //mutators
    public void setCode(String code) { this.code = code; }

    //methods
    private void setNull() {
        System.exit(70);
    }

    //initializers
    private void initialize() {
        Scanner reader;
        String next;
        //set scanner for enemyList.txt
        try {
            reader = new Scanner(new File("resources/enemyList.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //scan for this.code
        do
            next = reader.nextLine();
        while (!next.equals(String.format("code: [%s]", this.code)));
        //set stats
        next = reader.nextLine();
        setName(next.substring(7, 23)); //set name
        next = reader.nextLine();
        setMaxHealth(Integer.parseInt(next.substring(7, next.length()-1))); //set maxhp from index 7 onwards as int
        next = reader.nextLine();
        setHealth(Integer.parseInt(next.substring(4, next.length()-1))); //set hp from index 4 onwards as int
        reader.nextLine(); //skip 'moveset: '
        //fill moves and intentString
        for (int i = 0; intentString.isEmpty(); i++) {
            next = reader.next();
            if (next.equals(String.format("%d:", i))) //add move
                move.add(reader.nextLine());
            else if (next.equals("type:")) //add intentString
                intentString = reader.nextLine();
        }
    }

    //displays
}
