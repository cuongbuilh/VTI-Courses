package entity;

public class OverStudentException extends Exception{
    public OverStudentException(){
        super();
    }

    public OverStudentException(String msg){
        super(msg);
    }

    @Override
    public String getMessage() {
        return "Tao sinh vien qua so luong toi da";
    }
}
