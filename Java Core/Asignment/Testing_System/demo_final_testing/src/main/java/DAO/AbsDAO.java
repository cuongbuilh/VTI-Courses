package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbsDAO {
    /*
     *   chỉ chứa kết nối với cơ sở dữ liệu
     *      xem file entity.User trước.
     */
    private final String url = "jdbc:mysql://localhost:3306/Accounts";
    private final String user = "buicuong";
    private final String password = "buicuong";

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
