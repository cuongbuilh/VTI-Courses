package DAO;

import entity.BangSo;
import utils.IOManager;

import java.util.List;

public class BangSoDAO {
    final private String BANG_SO_DATA = "data/bangso_log.txt";
    final private IOManager ioManager = new IOManager();

    public List getBangSos() {
        return (List) ioManager.readObjects(BANG_SO_DATA);
    }

    public BangSo getBangSo() {
        List<BangSo> bangSoList = (List<BangSo>) ioManager.readObjects(BANG_SO_DATA);
        return bangSoList.get(bangSoList.size()-1);
    }

    public void saveBangSo(List bangSoList) {
        ioManager.writeObject(BANG_SO_DATA,bangSoList);
        System.out.println("BANG SO SAVED");
    }

    public void insertBangSo(BangSo bangSo) {
        List<BangSo> bangSoList = (List<BangSo>) ioManager.readObjects(BANG_SO_DATA);
        bangSoList.add(bangSo);
        ioManager.writeObject(BANG_SO_DATA,bangSoList);
    }
}
