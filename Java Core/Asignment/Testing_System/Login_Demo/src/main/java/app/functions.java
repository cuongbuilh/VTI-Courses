package app;

import entity.User;
import utils.MyInput;

public class functions extends Configs {
    final private MyInput input;

    public functions(){
        input = new MyInput();
    }

    public void printMenu(User user) {
        System.out.println("menu");
    }

    public int getSelection() {
        return 0;
    }

    public User process(User user, int selection) {
        switch (selection) {
            case EXIT:
                return user;
            case LOG_IN:
                 user = login();
                break;
            case LOG_OUT:
                user = logout();
                break;
            case YOUR_INFO:
                showInfomation(user);
                break;
            case ALL_INFO:
                showAllInfomation(user);
                break;
            case CREATE_USER:
                createUser(user);
                break;
            case DELETE_USER:
                deleteUser(user);
                break;
            case UPDATE_USER:
                updateUser(user);
                break;
            default:
                break;
        }
        return user;
    }

    private void updateUser(User user) {
    }

    private void deleteUser(User user) {
    }

    private void createUser(User user) {
    }

    private void showAllInfomation(User user) {
    }

    private void showInfomation(User user) {
    }

    private User logout() {
        return null;
    }

    private User login() {
        return null;
    }
}
