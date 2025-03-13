package gameCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class gameArtifact extends gamePickup {
    //attributes

    //constructors
    public gameArtifact() { setNull(); }
    public gameArtifact(String code) {
        setCode(code);
        initialize();
    }

    //accessors

    //mutators

    //methods

    //initializers
    public void initialize() {
        setGlitched(false);
        //read from file
        Scanner reader;
        String next;
        //set scanner for itemList.txt
        try {
            reader = new Scanner(new File("resources/artifactList.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //scan for this.code
        do
            next = reader.nextLine();
        while (!next.equals(String.format("code: [%s]", getCode())));
        //set stats
        next = reader.nextLine();
        setName(next.substring(7, 16)); //set name
        next = reader.nextLine();
        setLongName(next.substring(11, 26)); //set longName
        next = reader.nextLine();
        setEffect(next.substring(9, 72));
        next = reader.nextLine();
        setTier(next.substring(7, next.length()-1));
        next = reader.nextLine();
        setCost(Integer.parseInt(next.substring(6))); //set cost from index 6 onwards as int
    }

    //displays
}
