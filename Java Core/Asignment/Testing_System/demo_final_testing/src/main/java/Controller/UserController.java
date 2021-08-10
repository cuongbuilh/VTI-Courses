package Controller;

import entity.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private UserService userService;
    private User currUser;

    public UserController(){
        userService = new UserService();
    }

    public User login(String email, String password){
        currUser =  userService.login(email,password);
        return currUser;
    }

    public User logout(){
        currUser = null;
        return currUser;
    }

    public List<User> getUsers(){
        if (!currUser.isAdmin())
            return new ArrayList<User>();
        return userService.getUsers();
    }

    public boolean createUser(String fullname, String email){
        if (!currUser.isAdmin())
            return false;
        return userService.createUser(fullname,email);
    }

}
