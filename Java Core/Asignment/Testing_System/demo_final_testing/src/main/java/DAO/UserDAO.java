package DAO;

import entity.Admin;
import entity.Employee;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbsDAO {
    /*
     *  chỉ kết nối CSDL với Service;    CSDL <-> DAO <-> Service
     *  không kết nối với bất kì module nào khác
     *  mối DAO dành riêng cho 1 entity
     *  class này dành riêng cho user
     */

    private final String SELECT_ALL_USER = "select U.id as id,fullname,email,password,expInYear,skill from User U left join Admin A on (U.id = A.id)  left join Skill S on (U.id = S.id) order by U.id ;";
    private final String SELECT_USER_BY_ID = "select U.id as id,fullname,email,password,expInYear,skill from User U left join Admin A on (U.id = A.id)  left join Skill S on (U.id = S.id) where U.id=? order by U.id ;";
    private final String INSERT_USER = "insert into User(id,fullname,email,password) value(?,?,?,?)";
    private final String INSERT_SKILL = "inser into Skill(id,Skill) value(?,?)";
    private final String REMOVE_USER_ID = "delete from User U where U.id = ?";
    private final String REMOVE_SKILLS_BY_ID = "delete from skill S where S.id = ?";

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(SELECT_ALL_USER);
            while (resultSet.next()) {
                users.add(resultSetToUser(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public User getUser(int id) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = resultSetToUser(resultSet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return user;
    }

    public void removeUser(int id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        preparedStatement= connection.prepareStatement(REMOVE_SKILLS_BY_ID);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement(REMOVE_USER_ID);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    public int getMaxID(){
        String sql = "select max(id) from User";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet.next())
                return resultSet.getInt(1);
        } catch (SQLException e) {
            return -1;
        }
        return 0;
    }

    public boolean createUser(int id, String fullname, String email, String password, List<String> proSkills) throws SQLException {
        insertUser(id, fullname, email, password);
        insertSkills(id, proSkills);
        return true;
    }

    private void insertUser(int id, String fullname, String email, String password) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT_USER);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, fullname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        preparedStatement.executeUpdate();
    }

    private void insertSkills(int id, List<String> proSkills) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT_SKILL);
        for (String skill : proSkills) {
            try {
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, skill);
                preparedStatement.executeUpdate();
            } catch (Exception ignored) {
            }
        }

    }

    private User resultSetToUser(ResultSet resultSet) throws SQLException {
        User user = null;
        if (isAdmin(resultSet)) {
            user = new Admin(resultSet.getInt("id"),
                    resultSet.getString("fullname"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getInt("expInYear"));
        } else { // not be an admin
            user = new Employee(resultSet.getInt("id"),
                    resultSet.getString("fullname"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    getSkills(resultSet.getInt("id")));

//            while (user.getId() == resultSet.getInt("id")){
//                resultSet.next();
//            }
        }

        return user;
    }


    private boolean isAdmin(ResultSet resultSet) throws SQLException {
        ResultSet admins = getConnection().createStatement().executeQuery("select id from `Admin`");

        while (admins.next()){
            if (admins.getInt("id") == resultSet.getInt("id"))
                return true;
        }

        return false;
    }

    private List<String> getSkills(int id) throws SQLException {
        String sql = "select * from Skill where id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> skills = new ArrayList<>();
        while (resultSet.next()){
            skills.add(resultSet.getString("skill"));
        }
        return skills;
    }

    public static void main(String[] args) {
        new UserDAO().getUsers().forEach(u -> System.out.println(u));
    }

}
