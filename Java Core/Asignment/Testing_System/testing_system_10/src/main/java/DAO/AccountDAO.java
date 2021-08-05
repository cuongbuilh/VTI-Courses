package DAO;

import entity.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO extends AbsDAO {
    public Account getAccount(int id) {
        Account account = new Account();
        Connection conn = getCollection();
        String sql = "select * from Account where AccountId = " + id;
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            resultSet.next();
            account = resultSet.getObject(1, Account.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public static void main(String[] args) {
        System.out.println(new AccountDAO().getAccount(1));
    }
}
