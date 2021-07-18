package entity;

public class Position {
    public  static Position Dev = new Position("Dev");
    public static Position Test= new Position("Test");
    public static Position ScrumMaster = new Position("ScrumMaster");
    public static Position PM = new Position("PM");

    private int positionID;
    private String positionName;

    public Position() {
    }

    public Position(String name) {
        this.positionName = name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionID=" + positionID +
                ", positionName='" + positionName + '\'' +
                '}';
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Position(int positionID, String positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
    }
}
