package entity;

final public class PrimaryStudent extends Student {
    public static int numOfPrimayStudent = 0;

    public PrimaryStudent() throws OverStudentException{
        numOfPrimayStudent++;
    }

    @Override
    public void study() {

    }
}
