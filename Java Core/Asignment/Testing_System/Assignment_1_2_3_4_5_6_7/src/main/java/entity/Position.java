package entity;

public class Position {
    private int positionID;
    private String positionName;

    public Position() {
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
