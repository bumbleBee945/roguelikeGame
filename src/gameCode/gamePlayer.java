package gameCode;

import java.util.Scanner;
import java.util.ArrayList;

public class gamePlayer extends gameCharacter {
    //attributes
    int level;
    int room;
    int maxEnergy;
    int energy;
    boolean isCombat;
    gameCombat combat;
    gameItem active;
    Scanner input = new Scanner(System.in);
    ArrayList<gameItem> itemInv = new ArrayList<>();
    ArrayList<gameArtifact> artifactInv = new ArrayList<>();

    //constructors
    public gamePlayer() {
        initialize();
    }

    //accessors
    public int getLevel() { return this.level; }
    public int getRoom() { return this.room; }
    public int getMaxEnergy() { return this.maxEnergy; }
    public int getEnergy() { return this.energy; }
    public boolean isCombat() { return this.isCombat; }
    public gameCombat getCombat() { return this.combat; }
    public boolean hasActive() { return !this.active.isNull(); }

    //mutators
    public void setRoom(int level, int room) {
        this.level = level;
        this.room = room;
    }
    public void setMaxEnergy(int maxEnergy) { this.maxEnergy = maxEnergy; }
    public void setEnergy(int energy) { this.energy = energy; }
    public void setIsCombat(boolean isCombat) { this.isCombat = isCombat; }
    public void setCombat(gameCombat combat) { this.combat = combat; }
    public void setActive(gameItem active) { this.active = active; }
    public void addItem(String code) { this.itemInv.add(new gameItem(code)); }
    public void addArtifact(String code) { this.artifactInv.add(new gameArtifact(code)); }

    //methods
    private String returnAction(String action) {
        switch (action) {
            case "END": return "end";
            case "ACT": return "active";
            case "MMI": return "player";
            case "DIS": return "display";
            case "ESC": return "escape";
            case "EXI": System.exit(99);
        }
        for (gameItem i : itemInv)
            if (i.getCode().equals(action))
                return "item";
        for (gameArtifact i : artifactInv)
            if (i.getCode().equals(action))
                return "artifact";
        if (isCombat())
            for (gameEnemy i : combat.getList())
                if (i.getCode().equals(action))
                    return "enemy";
        return "null";
    }

    //initializers
    private void initialize() {
        setRoom(-1, 0);
        setMaxEnergy(3);
        setMaxHealth(80);
        setHealth(80);
        setIsCombat(false);
        setActive(new gameItem());
        addItem("KNI");
        addItem("HER");
        addItem("SAL");
        addArtifact("BER");
        addArtifact("SWI");
        addArtifact("COI");
        addArtifact("SPI");
    }

    //displays
    public void display() {
        printAll();
        boolean breakWhile = false;
        while (!breakWhile) {
            System.out.print("[-] ");
            String next = input.nextLine().toUpperCase();
            switch (returnAction(next)) {
                case "escape":
                    breakWhile = true;
                    break;
                case "item":
                    for (gameItem i : itemInv)
                        if (next.equals(i.getCode()))
                            i.display();
                    printAll();
                    break;
                case "artifact":
                    for (gameArtifact i : artifactInv)
                        if (next.equals(i.getCode()))
                            i.display();
                    printAll();
                    break;
                case "null":
                    printAll();
                    System.out.print("[x] Invalid input / ");
                    break;
            }

        }
    }
    private void printAll() {
        printTop();
        printMain();
        printActive();
        printArtifacts();
        printItems();
        printBottom();
    }
    private void printTop() {
        System.out.print("\n\n" +
                         "    |-----------------------------------------------------------------------------------------------------------------------------------|\n" +
                         "    |                                                         Me, Myself, and I                                                         |\n");
    }
    private void printMain() {
        System.out.printf("    |%s|\n", "-".repeat(131));
        if (isCombat()) { //display statuses, energy, health
            System.out.printf("    |%61sStatuses%62s", "", "");
            System.out.printf("    |%131s|\n", "");
            System.out.printf("    |       [============|%s|============|%s]       |\n", "=".repeat(44), "=".repeat(44));
            for (int i = 0; i < 4; i++) {
                System.out.print("    |       ");
                System.out.print("|            |                                            ");
                System.out.print("|            |                                            ");
                System.out.print("|       |\n    |       ");
                System.out.print("|            |                                            ");
                System.out.print("|            |                                            ");
                System.out.printf("    |       [============|%s|============|%s]       |\n", "=".repeat(44), "=".repeat(44));
            }
            System.out.printf("    |%131s|\n", "");
            System.out.printf("    |%24s[ENERGY]  (%2d/%-2d)%48s[HEALTH]  (%3d/%-3d)%23s|\n",
                    "", getMaxEnergy(), getEnergy(), "", getMaxHealth(), getHealth(), "");
            System.out.printf("    |%131s|\n", "");
        } else {
            System.out.print(String.format("    |%131s|\n", "").repeat(5));
            System.out.printf("    |%51sYou are displaying yourself.%52s|\n", "", "");
            System.out.print(String.format("    |%131s|\n", "").repeat(4));
            System.out.printf("    |%60sExit: [ESC]%60s|\n", "", "");
            System.out.print(String.format("    |%131s|\n", "").repeat(7));
        }
    }
    private void printActive() {
        System.out.printf("    |-----------------------------------------------------------------------------------------------------------------------------------|\n" +
                         "    |                                                            Active Item                                                            |\n" +
                         "    |                                                               %5s                                                               |\n" +
                         "    |       [=============================|=====================================================================================]       |\n" +
                         "    |       |                             |                                                                                     |       |\n" +
                         "    |       |      (%15s)      |      %-73s      |       |\n" +
                         "    |       |                             |                                                                                     |       |\n" +
                         "    |       [=============================|=====================================================================================]       |\n" +
                         "    |                                                                                                                                   |\n",
                         (isCombat() ? "[ACT]" : ""), (hasActive() ? active.getLongName() : ""), (hasActive() ? active.getEffect() : ""));
    }
    private void printArtifacts() {
        System.out.print("    |-----------------------------------------------------------------------------------------------------------------------------------|\n" +
                         "    |                                                             Artifacts                                                             |\n" +
                         "    |                                                                                                                                   |\n" +
                         "    |       [===================================================================================================================]       |\n" +
                         "    |       |                                                                                                                   |       |\n");
        for (int k = 0, i = 0; i < 2; i++, k += 7) { //loop twice, k is 0 -> 7
            System.out.print("    |       |      ");
            for (int j = 0; j < 7; j++) //print tops
                System.out.printf("[----%3s----]  ", (artifactInv.size() > j+k ? artifactInv.get(j+k).getCode() : "---"));
            System.out.print("    |       |\n    |       |      ");
            for (int j = 0; j < 7; j++) //print middles
                System.out.printf("| %9s |  ", (artifactInv.size() > j+k ? artifactInv.get(j+k).getName() : ""));
            System.out.print("    |       |\n    |       |      ");
            for (int j = 0; j < 7; j++) //print bottoms
                System.out.print("[-----------]  ");
            System.out.printf("    |       |\n    |       |%115s|       |\n", "");
        }
        System.out.print("    |       [===================================================================================================================]       |\n" +
                         "    |                                                                                                                                   |\n");
    }
    private void printItems() {
    System.out.print("    |-----------------------------------------------------------------------------------------------------------------------------------|\n" +
                     "    |                                                               Items                                                               |\n" +
                     "    |                                                                                                                                   |\n" +
                     "    |       [===================================================================================================================]       |\n" +
                     "    |       |                                                                                                                   |       |\n" +
                     "    |       |       ");
    for (int i = 0; i < itemInv.size(); i++) //if item exists, print top
        System.out.printf("[---%3s---]  %s", itemInv.get(i).getCode(), (i == 3 ? " " : ""));
    for (int i = 0; i < (8 - itemInv.size()); i++) //if item does not exist, print top
        System.out.printf("[---------]  %s", (i == 3 ? " " : ""));
    System.out.print("   |       |\n    |       |       ");
    for (int i = 0; i < itemInv.size(); i++) //if item exists, print middle
        System.out.printf("| %s |  %s", itemInv.get(i).getName(), (i == 3 ? " " : ""));
    for (int i = 0; i < (8 - itemInv.size()); i++) //if item does not exist, print middle
        System.out.printf("|         |  %s", (i == 3 ? " " : ""));
    System.out.print("   |       |\n    |       |       ");
    for (int i = 0; i < itemInv.size(); i++)
        System.out.printf("[---%s---]  %s", itemInv.get(i).isUsed() ? "OUT" : "("+itemInv.get(i).getEnergy()+")", (i == 3 ? " " : ""));
    for (int i = 0; i < (8 - itemInv.size()); i++)
        System.out.printf("[---------]  %s", (i == 3 ? " " : ""));
    System.out.print("   |       |\n" +
                     "    |       |                                                                                                                   |       |\n" +
                     "    |       [===================================================================================================================]       |\n" +
                     "    |                                                                                                                                   |\n");
    }
    private void printBottom() {
        System.out.print("    |-----------------------------------------------------------------------------------------------------------------------------------|\n" +
                         "    |                                                            End Display                                                            |\n" +
                         "    |                                                               [ESC]                                                               |\n" +
                         "    |-----------------------------------------------------------------------------------------------------------------------------------|\n\n");
    }
}
