package entity;

public class HinhHoc extends Configs {
    public static int SO_LUONG_HINH = 0;

    public HinhHoc() throws HinhHocException {
        if (SO_LUONG_HINH >= Configs.SO_LUONG_HINH_TOI_DA)
            throw new HinhHocException();
    }

}
