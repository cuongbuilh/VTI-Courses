package Controller;

import entity.User;
import service.UserService;

import java.util.List;

public class UserController implements IControler<User> {
    private final UserService userService;

    public UserController() {
        userService = new UserService();
    }

    @Override
    public User login() {
        return null;
    }

    @Override
    public User logout() {
        return null;
    }

    @Override
    public boolean delete(User user, String key) {
        return false;
    }

    @Override
    public boolean insert(User user, String key, String pass, String value) {
        return false;
    }

    @Override
    public List<? extends User> gets(User user) {
        return null;
    }

    @Override
    public User get() {
        return null;
    }
}
