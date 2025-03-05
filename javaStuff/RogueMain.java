public class RogueMain {
    public static void main(String[] args) {
        RogueMap floorMap = new RogueMap(1);
        floorMap.generateMap();
        floorMap.printMap();
    }
}