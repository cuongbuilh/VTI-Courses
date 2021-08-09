package utils;

import java.sql.*;

public class JDBCutils {
    private static JDBCutils instances;
    private Connection conn;
    private final String url = "jdbc:mysql://localhost:3306/Testing_System";
    private final String user = "buicuong";
    private final String password = "buicuong";

    private JDBCutils() {
    }

    public static JDBCutils getInstance() {
        if (instances == null)
            instances = new JDBCutils();
        return instances;
    }

    public Connection getConnection() {
        if (conn == null)
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connect Database Successful!");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.out.println("Could not connect database!");
            }
        return conn;
    }

    public void closeConnection() {
        if (conn == null) return;
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Close Connection!");
        }
    }

    public static void main(String[] args) throws SQLException {
        JDBCutils jdbCutils = new JDBCutils();
        PreparedStatement pre = jdbCutils.getConnection().prepareStatement("select * from Account where accountID = ?");
        pre.setInt(1,1);
        ResultSet rs = pre.executeQuery();
        if (rs.next()){
            System.out.println(rs.getString(2));
        }
        jdbCutils.closeConnection();
    }

}
