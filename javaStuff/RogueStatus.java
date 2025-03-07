import java.util.ArrayList;

public class RogueStatus {
    //statics
    public static ArrayList<RogueStatus> status = new ArrayList<>();
    public static RogueStatus getStatus(String statusCode) {
        for (int i = 0; i < status.size(); i++)
            if (status.get(i).getStatusCode() == statusCode)
                return status.get(i);
        return status.get(0);
    }
    public static void initStatuses() {
        status.add(new RogueStatus("STR", "Strength", "Deal +STR damage with attacks."));
        status.add(new RogueStatus("STB", "Stubborn", "On turn end, gain 1 Strength."));
        status.add(new RogueStatus("REL", "Relenting", "On turn end, lose 1 Strength."));
        status.add(new RogueStatus("STD", "Sturdy", "When attacked, reduce damage by STD and lose all STD."));
        status.add(new RogueStatus("BLS", "Blessing", "When next attacked this turn, reduce damage by 1."));
        status.add(new RogueStatus("BLK", "Block", "When attacked, reduce damage by BLK and lose BLK. Lose all BLK on turn end."));
        status.add(new RogueStatus("WEA", "Weak", "Deal -50% damage with attacks. Lose 1 WEA on turn end."));
        status.add(new RogueStatus("LFS", "Lifesteal", "Heal for unblocked damage dealt. Lose 1 LFS on turn end."));
        status.add(new RogueStatus("VUL", "Vulnerable", "Take +50% damage from every source. Lose 1 VUL on turn end."));
        status.add(new RogueStatus("DGE", "Dodge", "When next attacked, take no damage and lose 1 DGE. Lose 1 DGE on turn end."));
        status.add(new RogueStatus("BRN", "Burning", "On turn end, take 3 damage then lose 1 BRN."));
        status.add(new RogueStatus("PLG", "Plague", "On turn end, lose PLG health then lose 1 PLG."));
        status.add(new RogueStatus("SLW", "Slow", "On turn start, lose 1 energy then lose 1 SLW."));
    }
    //attributes
    private String statusCode;
    private String statusType;
    private String statusDescription;
    private int statusNum;

    //constructors
    public RogueStatus(String statusCode, String statusType, String statusDescription) {
        this.statusCode = statusCode;
        this.statusType = statusType;
        this.statusDescription = statusDescription;
    }
    public RogueStatus(RogueStatus status, int num) {
        this.statusCode = status.getStatusCode();
        this.statusType = status.getStatusType();
        this.statusDescription = status.getStatusDescription();
        this.statusNum = num;
    }

    //accessors
    public String getStatusType() { return this.statusType; }
    public String getStatusCode() { return this.statusCode; }
    public int getStatusNum() { return this.statusNum; }
    public String getStatusDescription() { return String.format("%-75s", this.statusDescription); }
}