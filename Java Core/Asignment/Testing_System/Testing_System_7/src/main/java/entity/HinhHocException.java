package entity;

public class HinhHocException extends Exception {
    public HinhHocException(){
        super();
    }

    public HinhHocException(String msg){
        super(msg);
    }

    @Override
    public String getMessage() {
        return "so luong hinh toi da: " + Configs.SO_LUONG_HINH_TOI_DA;
    }
}
