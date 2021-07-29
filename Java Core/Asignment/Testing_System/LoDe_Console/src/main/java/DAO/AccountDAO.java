package DAO;

import entity.Account;
import entity.Rule;
import exception.PermissonDeniedException;
import utils.IOManager;

import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    final private String USER_DATA_PATH = "data/users.bin";
    final private IOManager ioManager = new IOManager();

    public List getAccounts() {
        return (List) ioManager.readObjects(USER_DATA_PATH);
    }

    public List getAdmins() {
        List<Account> accountList = (List<Account>) ioManager.readObjects(USER_DATA_PATH);
        List<Account> admins = new ArrayList<>();

        for (Account acc : accountList) {
            boolean isAdmin = acc.getRules().contains(Rule.ADMIN) || acc.getRules().contains(Rule.SUPER_ADMIN);
            if (isAdmin)
                admins.add(acc);
        }

        return admins;
    }

    public List getSuperAdmin() {
        List<Account> accountList = (List<Account>) ioManager.readObjects(USER_DATA_PATH);
        List<Account> superAdmins = new ArrayList<>();

        for (Account acc : accountList) {
            boolean isSuperAdmin = acc.getRules().contains(Rule.SUPER_ADMIN);
            if (isSuperAdmin)
                superAdmins.add(acc);
        }

        return superAdmins;
    }

    public void saveAccounts(List accountList) {
        ioManager.writeObject(USER_DATA_PATH, accountList);
        System.out.println("accountList saved");
    }

    public void insertAccount(Account account) {
        List<Account> accountList = (List<Account>) ioManager.readObjects(USER_DATA_PATH);
        accountList.add(account);
        ioManager.writeObject(USER_DATA_PATH, accountList);
    }

    public void removeAccount(int id) throws PermissonDeniedException {
        List<Account> accountList = (List<Account>) ioManager.readObjects(USER_DATA_PATH);
        Account acc;
        for (int i=0; i<accountList.size(); i++) {
            acc = accountList.get(i);
            if (acc.getId()!=id) continue;
            if (acc.getRules().contains(Rule.SUPER_ADMIN))
                throw new PermissonDeniedException("CAN NOT REMOVE SUPER_ADMIN");
            accountList.remove(i);
            i--;
        }
    }
}
