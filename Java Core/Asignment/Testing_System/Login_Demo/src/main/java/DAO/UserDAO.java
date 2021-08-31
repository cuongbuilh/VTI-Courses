package DAO;

import entity.User;

import java.util.List;

public class UserDAO  extends AbsDAO implements IDAO<User>{

    public boolean isValid(String email, String password){
        return true;
    }

    @Override
    public List<User> gets() {
        return null;
    }

    @Override
    public User get(String email) {
        return null;
    }

    @Override
    public boolean has(String email) {
        return false;
    }

    public boolean has(int id){
        return false;
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(String email) {
        return 0;
    }
}
