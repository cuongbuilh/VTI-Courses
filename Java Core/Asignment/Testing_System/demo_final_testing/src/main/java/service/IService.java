package service;

import entity.User;

import java.util.List;

public interface IService {
    /*
     *  User Service Interface
     *  chỉ phục vụ các yêu cầu của Controller
     *  follow:    Controller <-> Service <-> DAO
     *  Interface dành riêng cho Service.
     */


    public User getUser(int id);

    public List<User> getUsers();

    public boolean removeUser(int id);

    public boolean createUser(String fullname, String email);

    public boolean createUser(User user);

    public User login(String email, String password);
}
