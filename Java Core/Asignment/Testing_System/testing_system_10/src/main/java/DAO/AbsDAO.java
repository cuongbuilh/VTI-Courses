package DAO;

import java.sql.*;

public class AbsDAO {

    public Connection getCollection() {
        final String url = "jdbc:mysql://localhost:3306/Accounts";
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

    public static void main(String[] args) throws SQLException {
        Connection conn = new AbsDAO().getCollection();
        System.out.println(conn);
////        String name = "Dev 1";
////        String sql = "insert into `Position`(PositionName) values(?)";
////        PreparedStatement preparedStatement = conn.prepareStatement(sql);
////        preparedStatement.setString(1,name);
////        preparedStatement.executeUpdate();
//        ResultSet resultSet = conn.createStatement().executeQuery("select * from `Position`");
//
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("PositionName"));
//        }
//        conn.close();
    }
}
