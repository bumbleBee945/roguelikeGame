package gameCode;

import java.util.ArrayList;
import java.util.Scanner;

import static gameCode.gameMain.midFormat;

public class gameCombat {
    //attributes
    private Scanner input = new Scanner(System.in);
    private String givenValue;
    int round;
    boolean endTurn;
    String action;
    gameRoom room;
    gamePlayer player;
    private ArrayList<gameEnemy> enemy = new ArrayList<>();

    //constructors
    public gameCombat() {
        setNull();
    }
    public gameCombat(gameRoom room, gamePlayer player) {
        setRoom(room);
        setPlayer(player);
    }

    //accessors
    public gameRoom getRoom() { return room; }
    public gamePlayer getPlayer() { return player; }
    public ArrayList<gameEnemy> getList() { return enemy; }
    public String getAction() { return action; }
    public gameEnemy getEnemy(String code) {
        for (gameEnemy e : enemy)
            if (e.getCode().equals(code))
                return e;
        return null;
    }

    //mutators
    public void setRoom(gameRoom room) { this.room = room; }
    public void setPlayer(gamePlayer player) { this.player = player; }

    //methods
    public void combat() {
        round = 0;
        player.setCombat(this);
        player.setIsCombat(true);
        for (int i = 0; i < room.getEnemyCount(); i++) { //spawn enemies
            enemy.add(new gameEnemy(room.getEnemy(i)));
        }
        while (!enemy.isEmpty()) {
            round++;
            player.replenish();
            for (gameEnemy e : enemy) e.intent(round); //set intents
            endTurn = false;
            while (!endTurn) { playerTurn(); }
            for (gameEnemy e : enemy) {
                display(e.turn(player));
                System.out.print("[=] ");
                input.nextLine();
            }
        }
        player.setIsCombat(false);
        player.setBaseCombats(player.getBaseCombats() + 1);
        display("You  win!");
        System.out.print("[=] ");
        input.nextLine();
        reward();
    }
    private void reward() {
        int rewardG;
        String rewardI;
        switch (room.getType()) {
            case "enemy" -> {
                rewardG = gameMain.random(5, 15);
                display(String.format("+%d gold!", rewardG));
                System.out.print("[=] ");
                input.nextLine();
                player.addGold(rewardG);

                rewardI = gameMain.randomItemCode("base");
                display(String.format("+%s!", new gameItem(rewardI).getLongName().trim()));
                System.out.print("[=] ");
                input.nextLine();
                player.addItem(rewardI);

                if (player.getBaseCombats() % 3 == 0) {
                    String rewardA = gameMain.randomArtifactCode("base");
                    display(String.format("+%s!", new gameItem(rewardA).getLongName()));
                    System.out.print("[=] ");
                    input.nextLine();
                    player.addArtifact(rewardA);
                }
            }
            case "brute" -> {
                rewardG = gameMain.random(30, 45);
                display(String.format("+%d gold!", rewardG));
                System.out.print("[=] ");
                input.nextLine();
                player.addGold(rewardG);

                String rewardAa = gameMain.randomArtifactCode("good");
                String rewardAb = gameMain.randomArtifactCode("good");
                display(String.format("choice:artifact:%s:%s",
                        new gameArtifact(rewardAa).getCode(), new gameArtifact(rewardAb).getCode()));
                while (true) {
                    System.out.print("[-] ");
                    givenValue = input.nextLine().toUpperCase();
                    if (!givenValue.equals(rewardAa) && !givenValue.equals(rewardAb)) {
                        display(String.format("choice:artifact:%s:%s",
                                new gameArtifact(rewardAa).getCode(), new gameArtifact(rewardAb).getCode()));
                        System.out.print("[x] Invalid input / ");
                        continue;
                    }
                    break;
                }
                player.addArtifact(givenValue);

            }
            case "bossA" -> {
                rewardG = gameMain.random(70, 90);
                display(String.format("+%d gold!", rewardG));
                System.out.print("[=] ");
                input.nextLine();
                player.addGold(rewardG);

                String rewardIa = gameMain.randomItemCode("great");
                String rewardIb = gameMain.randomItemCode("great");
                display(String.format("choice:item:%s:%s",
                        new gameArtifact(rewardIa).getCode(), new gameArtifact(rewardIb).getCode()));
                while (true) {
                    System.out.print("[-] ");
                    givenValue = input.nextLine().toUpperCase();
                    if (!givenValue.equals(rewardIa) && !givenValue.equals(rewardIb)) {
                        display(String.format("choice:item:%s:%s",
                                new gameArtifact(rewardIa).getCode(), new gameArtifact(rewardIb).getCode()));
                        System.out.print("[x] Invalid input / ");
                        continue;
                    }
                    break;
                }
                player.addItem(givenValue);

                String rewardAa = gameMain.randomArtifactCode("great");
                String rewardAb = gameMain.randomArtifactCode("great");
                String rewardAc = gameMain.randomArtifactCode("great");
                display(String.format("choice:artifact:%s:%s:%s",
                        new gameArtifact(rewardAa).getCode(), new gameArtifact(rewardAb).getCode(), new gameArtifact(rewardAc).getCode()));
                while (true) {
                    System.out.print("[-] ");
                    givenValue = input.nextLine().toUpperCase();
                    if (!givenValue.equals(rewardAa) && !givenValue.equals(rewardAb) && !givenValue.equals(rewardAc)) {
                        display(String.format("choice:artifact:%s:%s:%s",
                                new gameArtifact(rewardAa).getCode(), new gameArtifact(rewardAb).getCode(), new gameArtifact(rewardAc).getCode()));
                        System.out.print("[x] Invalid input / ");
                        continue;
                    }
                    break;
                }
                player.addArtifact(givenValue);
            }
        }
    }

    private void playerTurn() {
        action = "playerTurn";
        display();
        while (true) {
            System.out.print("[-] ");
            givenValue = input.nextLine().toUpperCase();
            if (!givenValue.matches("...") || player.returnAction(givenValue).equals("none")) {
                display();
                System.out.print("[x] Invalid input / ");
                continue;
            }
            break;
        }
        action(player.returnAction(givenValue), givenValue);
    }
    private void playerItem(String code) {
        action = "playerItem";
        display();
        String r;
        while (true) {
            System.out.print("[-] ");
            givenValue = input.nextLine().toUpperCase();
            r = player.returnAction(givenValue);
            if ((!givenValue.matches("...")) ||
                    !(r.equals("escape") || r.equals("enemy") || r.equals("display") || r.equals("player"))) {
                display();
                System.out.print("[x] Invalid input / ");
                continue;
            }
            break;
        }
        if (r.equals("enemy"))
            code += ":" + givenValue;
        action(r, code);
    }

    private void action(String type, String code) {
        switch (type) {
            case "player":
                if (action.equals("playerTurn")) {
                    player.display();
                } else if (action.equals("playerItem")) {
                    display(player.use(player.getItem(code), player));
                    System.out.print("[=]" );
                    input.nextLine();
                }
                break;
            case "enemy":
                if (action.equals("playerTurn")) {
                    getEnemy(code).display();
                }
                if (action.equals("playerItem")) {
                    String[] parts = code.split(":");
                    display(player.use(player.getItem(parts[0]), getEnemy(parts[1])));
                    System.out.print("[=]" );
                    input.nextLine();
                }
                break;
            case "item":
                if (action.equals("playerTurn")) {
                    playerItem(code);
                }
                break;
            case "artifact":
                if (action.equals("playerTurn")) {
                    player.getArtifact(code).display();
                }
                break;
            case "display":
                if (action.equals("playerItem")) {
                    player.getItem(code).display();
                }
                break;
            case "escape":
                break;
            case "end":
                endTurn = true;
                break;
        }
    }

    //initializers
    private void setNull() {
        System.exit(60);
    }

    //displays
    public void display() {
        display("");
    }
    public void display(String str) {
        for (int i = 0; i < enemy.size(); i++) //check dead
            if (enemy.get(i).getHealth() == 0)
                enemy.remove(i--); //kill
        printAll(str);
    }
    private void printAll(String str) {
        gameMain.printTop(String.format("Combat! (Round %d)", round));
        printCharacters();
        player.printActive();
        player.printArtifacts();
        player.printItems();
        if (!str.isEmpty()) {
            if (str.equals("energy"))
                str = "You do not have the energy for this!";
            else if (str.startsWith("used")) {
                String[] parts = str.split(":");
                str = midFormat(String.format("Used %s on %s!", parts[1].trim(), parts[2].trim()), 50);
            } else if (str.equals("out")) {
                str = "This item's out of uses!";
            }
            if (str.startsWith("choice")) {
                String[] parts = str.split(":");
                String[] names = new String[parts.length - 2];
                if (parts[1].equals("artifact"))
                    for (int i = 0; i < names.length; i++) {
                        names[i] = "+" + new gameArtifact(parts[i + 2]).getLongName().trim() + "!";
                        parts[i + 2] = "[" + parts[i + 2] + "]";
                    }
                else
                    for (int i = 0; i < names.length; i++) {
                        names[i] = "+" + new gameItem(parts[i + 2]).getLongName().trim() + "!";
                        parts[i + 2] = "[" + parts[i + 2] + "]";
                    }
                if (names.length == 2)
                    gameMain.printBottom
                        (String.format("%s|%s", midFormat(names[0], 65), midFormat(names[1], 65)),
                        String.format("%s|%s", midFormat(parts[2], 65), midFormat(parts[3], 65)));
                else
                    gameMain.printBottom
                        (String.format("%s|%s|%s", midFormat(names[0], 43), midFormat(names[1], 43), midFormat(names[2], 43)),
                        String.format("%s|%s|%s", midFormat(parts[2], 43), midFormat(parts[3], 43), midFormat(parts[4], 43)));

            } else
                gameMain.printBottom(str, "[Enter]");
        } else if (action.equals("playerItem"))
            gameMain.printBottom
                    (String.format("%s|%s", midFormat("Display", 65), midFormat("Exit Menu", 65)),
                    String.format("%s|%s", midFormat("[DIS]", 65), midFormat("[ESC]", 65)));
        else
            gameMain.printBottom("End  Turn", "[END]");
    }
    private void printCharacters() {
        String[] charArray = setCharArray();
        System.out.printf("    |%65s|%65s|\n", "-".repeat(65), "-".repeat(65));
        System.out.printf("    |%65s|%65s|\n", "", charArray[0]);
        System.out.printf("    |%65s|%65s|\n", "", charArray[1]);
        System.out.printf("    |%18s|------------MMI------------|%18s|%65s|\n", "", "", charArray[2]);
        for (int i = 0; i < 3; i++)
            System.out.printf("    |%18s|%27s|%18s|%65s|\n", "", "", "", charArray[3+i]);
        System.out.printf("    |%18s|%12sMe,%12s|%18s|%65s|\n", "", "", "", "", charArray[6]);
        System.out.printf("    |%18s|%10sMyself,%10s|%18s|%65s|\n", "", "", "", "", charArray[7]);
        System.out.printf("    |%18s|%11sand I%11s|%18s|%65s|\n", "", "", "", "", charArray[8]);
        for (int i = 0; i < 3; i++)
            System.out.printf("    |%18s|%27s|%18s|%65s|\n", "", "", "", charArray[9+i]);
        System.out.printf("    |%18s|%27s|%18s|%65s|\n", "", "-".repeat(27), "", charArray[12]);
        System.out.printf("    |%65s|%65s|\n", "", charArray[13]);
        System.out.printf("    |%24s[ENERGY]  (%2d/%-2d)%24s|%65s|\n", "", player.getEnergy(), player.getMaxEnergy(), "", charArray[14]);
        System.out.printf("    |%23s[HEALTH]  (%3d/%-3d)%23s|%65s|\n", "", player.getHealth(), player.getMaxHealth(), "", charArray[15]);
        System.out.printf("    |%29s[     ]%29s|%65s|\n", "", "", charArray[16]);
        System.out.printf("    |%65s|%65s|\n", "", charArray[17]);
    }
    private String[] setCharArray() {
        String[] result = new String[18];
        for (int i = 0; i < 18; i++) //empty result[]
            result[i] = String.format("%65s", "");

        int start = 0; int plus = 0; // add offsets for enemy amounts
        if (enemy.size() == 1) { start = 5; plus = 3; }
        else if (enemy.size() == 2) { start = 1; plus = 1; }

        for (int i = 0; i < enemy.size(); i++) { // add enemy strings
            gameEnemy e = enemy.get(i); // e is current enemy
            result[start++] = String.format("%16s|-------------%3s-%d-------------|%16s", "", e.getCode(), i + 1, "");
            result[start++] = String.format("%16s|        %15s        |%16s", "", e.getName(), "");
            result[start++] = String.format("%16s|%31s|%16s", "", "-".repeat(31), "");
            start += plus;
            result[start++] = String.format("%20s%25s%20s", "", e.displayIntent(), "");
            result[start++] = String.format("%23s[HEALTH]  (%3d/%-3d)%23s", "", e.getHealth(), e.getMaxHealth(), "");
            result[start++] = String.format("%29s[     ]%29s", "", "");
            start += plus * 2; // if 2 enemies, this just adds 2 lol
        }
        return result;
    }

}
