package gameCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static gameCode.gameMain.midFormat;
import static gameCode.gameMain.random;

public class gameEnemy extends gameCharacter {
    //attributes
    private Scanner input = new Scanner(System.in);
    private String code;
    private ArrayList<String> move = new ArrayList<>();
    private String intentString = "";
    private int intentMove;

    //constructors
    public gameEnemy() { setNull(); }
    public gameEnemy(String code) {
        setCode(code);
        initialize();
    }

    //accessors
    public String getCode() { return code; }

    //mutators
    public void setCode(String code) { this.code = code; }

    //methods
    public String turn(gamePlayer p) {
        String[] parts = move.get(intentMove).split(", ");
        String desc = "";
        if (parts[0].equals("attack")) {
            desc = " attacked for " + parts[1] + " damage!";
            p.subHealth(Integer.parseInt(parts[1]));
        } else if (parts[0].equals("block")) {
            desc = " blocked " + parts[1] + " damage!";
            // apply block
        } else if (parts[0].equals("status")) {
            desc = String.format(" applied %s %s%s!", parts[2], parts[1], parts.length > 3 ? " to itself" : "");
            // apply status
        }
        return midFormat(String.format("%s%s", getName().trim(), desc), 45);
    }

    public void intent(int round) {
        String[] intentS = intentString.split("(:|, )"); // get intent string to pieces

        int a = round;
        int b = -1;
        do { // b ends with the round of target token
            b += 2;
            if (intentS[b].equals("+")) // exit if end
                break;
            a -= Integer.parseInt(intentS[b]);
        } while (a > 0);

        intentMove = intentS[b-1].charAt(random(0, intentS[b-1].length()-1)) - '0'; // if iS[b-1] is "014", this is 0-2, so 0/1/4 at random
    }
    public String displayIntent() {
        String[] moveS = move.get(intentMove).split(", "); //split 'status, wea, 3' to 3 tokens
        switch (moveS[0]) { //attack, block, status
            case "attack":
                return String.format(" [INTENT] (Attack  * %2s) ", moveS[1]);
            case "block":
                return String.format("  [INTENT] (Block * %2s)  ", moveS[1]);
            case "status":
                if (moveS.length != 4) // if self doesn't exist
                    return String.format("[INTENT] (Status: %-6s)", moveS[2]+" "+moveS[1]);
                else
                    return String.format(" [INTENT] (Self: %-6s) ", moveS[2]+" "+moveS[1]);
        }
        return "null";
    }

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
        setName(next.substring(7, 22)); //set name
        next = reader.nextLine();
        setMaxHealth(Integer.parseInt(next.substring(7))); //set maxhp from index 7 onwards as int
        next = reader.nextLine();
        setHealth(Integer.parseInt(next.substring(4))); //set hp from index 4 onwards as int
        reader.nextLine(); //skip 'moveset: '
        //fill moves and intentString
        for (int i = 0; intentString.isEmpty(); i++) {
            next = reader.next();
            if (next.equals(String.format("%d:", i))) //add move
                move.add(reader.nextLine().substring(1));
            else if (next.equals("type:")) //add intentString
                intentString = reader.nextLine().substring(1);
        }
    }

    //displays
    public void display() {
        printAll();
        System.out.print("[=] ");
        input.nextLine();
    }
    private void printAll() {
        gameMain.printTop(getName());
        printMain();
        printName();
        printIntent();
        printVitality();
        gameMain.printBottom("End Display", "[Enter]");
    }
    private void printMain() {
        System.out.print(String.format("    |%131s|\n", "").repeat(5));
        System.out.printf("    |%s|\n", midFormat("You are displaying an enemy.", 131));
        System.out.print(String.format("    |%131s|\n", "").repeat(4));
        System.out.printf("    |%s|\n", midFormat("Exit: [ESC]", 131));
        System.out.print(String.format("    |%131s|\n", "").repeat(7));
    }
    private void printName() {
        System.out.printf("    |%s|\n", "-".repeat(131));
        System.out.printf("    |%63sName%64s|\n", "", "");
        System.out.printf("    |%131s|\n", "");
        System.out.printf("    |       [%s|%s]       |\n", "=".repeat(81), "=".repeat(33));
        System.out.printf("    |       |%43s|%37s|%33s|       |\n", "", "" ,"");
        System.out.printf("    |       |%38s%15s%38s|%14s[%3s]%14s|       |\n", "", getName(), "", "", getCode(), "");
        System.out.printf("    |       |%43s|%37s|%33s|       |\n", "", "" ,"");
        System.out.printf("    |       [%s|%s]       |\n", "=".repeat(81), "=".repeat(33));
        System.out.printf("    |%131s|\n", "");
    }
    private void printIntent() {
        String[] moveS = move.get(intentMove).split(", ");
        String intentDesc = switch (moveS[0]) {
            case "attack" -> String.format("This enemy intends to attack for %s damage.", moveS[1]);
            case "block" -> String.format("This enemy intends to block for %s damage.", moveS[1]);
            case "status" ->
                    String.format("This enemy intends to apply %s %s%s.", moveS[1], moveS[2], (moveS.length > 3 ? " to itself" : ""));
            default -> "";
        };
        System.out.printf("    |%s|\n", "-".repeat(131));
        System.out.printf("    |%s|\n", midFormat("Intent", 131));
        System.out.printf("    |%131s|\n", "");
        System.out.printf("    |       [%s]       |\n", "=".repeat(115));
        System.out.printf("    |%s|       |\n", midFormat(displayIntent(), 115));
        System.out.print(String.format("    |       |%115s|       |\n", "").repeat(3));

        System.out.printf("    |       |%s|       |\n", midFormat(intentDesc, 115));

        if (moveS[0].equals("status")) {
            String statusDesc = String.format("[%3s]  -  %s", moveS[1], "");
            System.out.printf("    |       |%s|       |\n", midFormat(statusDesc, 115));
        } else
            System.out.printf("    |       |%115s|       |\n", "");

        System.out.print(String.format("    |       |%115s|       |\n", "").repeat(3));
        System.out.printf("    |       [%s]       |\n", "=".repeat(115));
        System.out.printf("    |%131s|\n", "");

    }
    private void printVitality() {
        System.out.printf("    |%s|\n", "-".repeat(131));
        System.out.printf("    |%s|\n", midFormat("Vitality", 131));
        System.out.printf("    |%131s|\n", "");
        System.out.printf("    |       [%s|%s]       |\n", "=".repeat(29), "=".repeat(85));
        System.out.printf("    |       |%s|%s|       |\n", midFormat("Health", 29), midFormat("Statuses", 85));
        System.out.printf("    |       |%29s|%85s|       |\n", "", "");
        System.out.printf("    |       |%s|%s|       |\n",
                midFormat(String.format("(%3d/%-3d)", getHealth(), getMaxHealth()), 29), midFormat("[     ]", 85));
        System.out.print(String.format("    |       |%29s|%85s|       |\n", "", "").repeat(2));
        System.out.printf("    |       [%s|%s]       |\n", "=".repeat(29), "=".repeat(85));
        System.out.printf("    |%131s|\n", "");
    }
}
