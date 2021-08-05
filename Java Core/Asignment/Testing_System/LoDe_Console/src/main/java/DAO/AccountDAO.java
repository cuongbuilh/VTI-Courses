package DAO;

import entity.Account;
import entity.Rule;
import exception.PermissonDeniedException;
import utils.IOManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    final private String USER_DATA_PATH = "data/users.txt";
    final private IOManager ioManager = new IOManager();

    public List getAccounts() {
        return (List) ioManager.readObjects(USER_DATA_PATH);
    }

    public Account getAccount(String username) {
        if (username == null) return null;
        List<Account> accountList = (List<Account>) ioManager.readObjects(USER_DATA_PATH);
        if (accountList == null) return null;
        for (Account acc : accountList) {
            if (username.equals(acc.getUsername()))
                return acc;
        }
        return null;
    }

    public boolean isExists(String username) {
        return getAccount(username) != null;
    }

    public List getAdmins() {
        List<Account> accountList = (List<Account>) ioManager.readObjects(USER_DATA_PATH);
        if (accountList == null) return new ArrayList<Account>();
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
        if (accountList == null) return new ArrayList<Account>();
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
        if (!isExists(account.getUsername())) {
            System.out.println("account has been exists!");
            return;
        }

        List<Account> accountList = (List<Account>) ioManager.readObjects(USER_DATA_PATH);
        if (accountList == null) accountList = new ArrayList<Account>();
        accountList.add(account);
        ioManager.writeObject(USER_DATA_PATH, accountList);
    }

    public void removeAccount(int id) throws PermissonDeniedException {
        List<Account> accountList = (List<Account>) ioManager.readObjects(USER_DATA_PATH);
        if (accountList == null) return;
        Account acc;
        for (int i = 0; i < accountList.size(); i++) {
            acc = accountList.get(i);
            if (acc.getId() != id) continue;
            if (acc.getRules().contains(Rule.SUPER_ADMIN))
                throw new PermissonDeniedException("CAN NOT REMOVE SUPER_ADMIN");
            accountList.remove(i);
            i--;
        }
    }
}
