package DAO;

import entity.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountDAOTest {

    @Test
    void getAccounts() {
    }

    @Test
    void getAdmins() {
    }

    @Test
    void getSuperAdmin() {

    }

    @Test
    void saveAccounts() {
    }

    @Test
    void insertAccount() {
        Account account = new Account(1);
        AccountDAO dao = new AccountDAO();
        dao.insertAccount(account);
    }

    @Test
    void deleteAccount() {
    }
}