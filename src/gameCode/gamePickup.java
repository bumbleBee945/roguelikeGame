package gameCode;

import java.util.Scanner;

public abstract class gamePickup {
    //attributes
    private Scanner input = new Scanner(System.in);
    private String tier;
    private String longName;
    private String name;
    private String effect;
    private String code;
    private int cost;
    private boolean glitched;

    //constructors

    //accessors
    public boolean isNull() { return name.equals("null"); }
    public String getTier() { return tier; }
    public String getName() { return name; }
    public String getLongName() { return longName; }
    public String getEffect() { return effect; }
    public String getCode() { return code; }
    public int getCost() { return cost; }
    public boolean isGlitched() { return glitched; }

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
        printAll();
        System.out.print("[=] ");
        input.nextLine();
    }
    private void printAll() {
        gameMain.printTop(getLongName());
        printMain();
        printName();
        printEffect();
        printSpecs();
        gameMain.printBottom("End Display", "[Enter]");
    }
    private void printMain() {
        System.out.printf("    |%s|\n", "-".repeat(131));
        System.out.print(String.format("    |%131s|\n", "").repeat(5));
        if (this instanceof gameItem)
            System.out.printf("    |%52sYou are displaying an item.%52s|\n", "", "");
        else
            System.out.printf("    |%50sYou are displaying an artifact.%50s|\n", "", "");
        System.out.print(String.format("    |%131s|\n", "").repeat(4));
        System.out.printf("    |%59sExit: [Enter]%59s|\n", "", "");
        System.out.print(String.format("    |%131s|\n", "").repeat(7));
    }
    private void printName() {
        String nameS = getName();
        if (this instanceof gameItem)
            nameS = " " + nameS + " ";
        System.out.printf("    |%s|\n", "-".repeat(131));
        System.out.printf("    |%63sName%64s|\n", "", "");
        System.out.printf("    |%131s|\n", "");
        System.out.printf("    |       [%s|%s|%s]       |\n", "=".repeat(43), "=".repeat(37), "=".repeat(33));
        System.out.printf("    |       |%43s|%37s|%33s|       |\n", "", "" ,"");
        System.out.printf("    |       |%14s%15s%14s|%14s%9s%14s|%14s[%3s]%14s|       |\n", "", getLongName(), "", "", nameS, "", "", getCode(), "");
        System.out.printf("    |       |%43s|%37s|%33s|       |\n", "", "" ,"");
        System.out.printf("    |       [%s|%s|%s]       |\n", "=".repeat(43), "=".repeat(37), "=".repeat(33));
        System.out.printf("    |%131s|\n", "");
    }
    private void printEffect() {
        System.out.printf("    |%s|\n", "-".repeat(131));
        System.out.printf("    |%62sEffect%63s|\n", "", "");
        System.out.printf("    |%131s|\n", "");
        System.out.printf("    |       [%s]       |\n", "=".repeat(115));
        System.out.print(String.format("    |       |%115s|       |\n", "").repeat(4));
        System.out.printf("    |       |%26s%63s%26s|       |\n", "", getEffect(), "");
        System.out.print(String.format("    |       |%115s|       |\n", "").repeat(4));
        System.out.printf("    |       [%s]       |\n", "=".repeat(115));
        System.out.printf("    |%131s|\n", "");
    }
    private void printSpecs() {
        String tierS = switch (getTier()) {
            case "good" -> "           Base          [Good]          Great           ";
            case "great" -> "           Base           Good          [Great]          ";
            default -> "          [Base]          Good           Great           ";
        };
        String energyS = "";
        if (this instanceof gameItem)
            energyS = String.format("%1d Energy", ((gameItem)this).getEnergy());
        System.out.printf("    |%s|\n", "-".repeat(131));
        System.out.printf("    |%63sSpecs%63s|\n", "", "");
        System.out.printf("    |%131s|\n", "");
        System.out.printf("    |       [%s|%s]       |\n", "=".repeat(57), "=".repeat(57));
        System.out.printf("    |       |%26sCost%27s|%25sRarity%26s|       |\n", "", "", "", "");
        System.out.printf("    |       |%57s|%57s|       |\n", "", "");
        System.out.printf("    |       |%26s%-3dG%27s|%57s|       |\n", "", cost, "", tierS);
        System.out.printf("    |       |%24s%8s%25s|%57s|       |\n", "", energyS, "", "");
        System.out.printf("    |       |%57s|%57s|       |\n", "", "");
        System.out.printf("    |       [%s|%s]       |\n", "=".repeat(57), "=".repeat(57));
        System.out.printf("    |%131s|\n", "");
    }
}
