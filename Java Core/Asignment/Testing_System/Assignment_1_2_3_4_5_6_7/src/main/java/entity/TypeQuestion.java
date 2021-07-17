package entity;

public class TypeQuestion {
    private int typeID;
    private TypeName typeName;

    public enum TypeName {ESSAY, MULTIPLE_CHOISE}



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

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    public TypeQuestion(int typeID, TypeName typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public TypeQuestion() {
    }
}
