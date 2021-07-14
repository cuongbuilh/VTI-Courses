package entity;

public class TypeQuestion {
    private int typeID;
    private String typeName;

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "typeID=" + typeID +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public TypeQuestion(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public TypeQuestion() {
    }
}
