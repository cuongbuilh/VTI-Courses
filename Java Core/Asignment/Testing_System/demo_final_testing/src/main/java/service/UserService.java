package service;

import DAO.UserDAO;
import entity.Admin;
import entity.Employee;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IService {
    UserDAO userDAO = new UserDAO();

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public boolean removeUser(int id) {
        try {
            userDAO.removeUser(id);
            return true;
        } catch (SQLException ignored) {
        }
        return false;
    }

    @Override
    public boolean createUser(String fullname, String email) {
        try {
            userDAO.createUser(userDAO.getMaxID()+1, fullname, email, "12345", new ArrayList<String>());
            return true;
        } catch (SQLException ignored){
        }
        return false;
    }

    @Override
    public boolean createUser(User user) {
        if (user instanceof Admin)
            return false;
        try {
            userDAO.createUser(user.getId(), user.getFullname(), user.getEmail(), user.getPassword(), ((Employee)user).getProSkill());
            return true;
        } catch (SQLException ignored) {
        }
        return false;
    }

    @Override
    public User login(String email, String password) {
        List<User> users = getUsers();
        for (User user:users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }


}
