package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

abstract public class AbsDAO {
    public Connection getCollection() {
        final String url = "jdbc:mysql://localhost:3306/Testing_System";
        final String user = "buicuong";
        final String password = "buicuong";
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connect Database Successful!");
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Connect Database Fail!");
        return null;
    }

//    public static void main(String[] args) {
//        System.out.println(new AbsDAO().getCollection());
//    }
}
