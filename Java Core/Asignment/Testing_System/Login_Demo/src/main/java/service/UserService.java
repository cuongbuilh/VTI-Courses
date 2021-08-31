package service;

import DAO.UserDAO;
import entity.User;

import java.util.List;

public class UserService implements IService<User>{
    private final UserDAO userDAO;

    public UserService(){
        userDAO = new UserDAO();
    }

    @Override
    public User get(String email) {
        return userDAO.get(email);
    }

    @Override
    public List<User> gets() {
        return userDAO.gets();
    }

    @Override
    public int insert(String email, String password, String fullname) {
        User user = new User(fullname,email,password);
        return 0;
    }

    @Override
    public int update(User user) {
        return userDAO.update(user);
    }

    @Override
    public int delete(String email) {
        return userDAO.delete(email);
    }


}
