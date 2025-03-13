package gameCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class gameItem extends gamePickup {
    //attributes
    boolean used;
    int energy;

    //constructors
    public gameItem() { setNull(); }
    public gameItem(String code) {
        setCode(code);
        initialize();
    }

    //accessors
    public boolean isUsed() { return this.used; }
    public int getEnergy() { return this.energy; }

    //mutators
    public void setUsed(boolean used) { this.used = used; }
    public void setEnergy(int energy) { this.energy = energy; }

    //methods

    //initializers
    public void initialize() {
        setGlitched(false);
        setUsed(false);
        //read from file
        Scanner reader;
        String next;
        //set scanner for itemList.txt
        try {
            reader = new Scanner(new File("resources/itemList.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //scan for this.code
        do
            next = reader.nextLine();
        while (!next.equals(String.format("code: [%s]", getCode())));
        //set stats
        next = reader.nextLine();
        setName(next.substring(7, 14)); //set name
        next = reader.nextLine();
        setLongName(next.substring(11, 26)); //set longName
        next = reader.nextLine();
        setEffect(next.substring(9, 72));
        next = reader.nextLine();
        setTier(next.substring(7, next.length()-1));
        next = reader.nextLine();
        setCost(Integer.parseInt(next.substring(6))); //set cost from index 6 onwards as int
        next = reader.nextLine();
        setEnergy(Integer.parseInt(next.substring(8))); //set energy from index 8 onwards as int
    }

    //displays
}
