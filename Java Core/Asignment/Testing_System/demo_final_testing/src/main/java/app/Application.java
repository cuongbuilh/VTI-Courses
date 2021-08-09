package app;

import Controller.UserController;
import entity.User;
import jdk.swing.interop.SwingInterOpUtils;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class Application {
    private static User currUser;
    private static UserController userController;

    private final static int EXIT = 0;
    private final static int LOG_IN = 1;
    private final static int SHOW_USER_INFO = 2;
    private final static int CREATE_USER = 3;
    private final static int SHOW_LIST_USER = 4;
    private final static int LOG_OUT = 9;
    private final static int DEFAULT = Integer.MAX_VALUE;


    public static void main(String[] args) {
        // declare in_use variable
        int choice = DEFAULT;
        currUser = null;
        userController = new UserController();

        // start-app
        do {
            printMenuSelections();
            try {
                choice = inputSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                choice = DEFAULT;
                continue;
            }
            process(choice);
        } while (choice != EXIT);

        // the-end
        System.out.println("BYE");
    }

    public static void printMenuSelections() {
        String userName = (currUser == null) ? "Guest" : currUser.getFullname();
        System.out.println("\n------------ SELECTIONS ------------");
        System.out.println("you are: " + userName);
        System.out.print("""
                    0, exit
                    1, login
                    2, your infomation
                    3, create new user (only admin)
                    4, show all user
                    9, logout
                """);
        System.out.println("------------------------------------");
    }

    public static int inputSelection() throws Exception {
        int choice = DEFAULT;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("enter your choice: ");
            choice = scanner.nextInt();
        } catch (Exception e) {
            throw new Exception("BAD INPUT ! (not in menu selection!!)");
        }
        return choice;
    }

    public static void process(int selection) {
        switch (selection) {
            case EXIT:
                return;
            case LOG_IN:
                login();
                break;
            case SHOW_USER_INFO:
                showUserInfo();
                break;
            case CREATE_USER:
                createUser();
                break;
            case SHOW_LIST_USER:
                showListUser();
                break;
            case LOG_OUT:
                logout();
                break;
            default:
                break;
        }
    }

    private static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Login:");
        System.out.print("email: ");
        String email = sc.next();
        System.out.print("passwd: ");
        String pass = sc.next();
        currUser = userController.login(email, pass);
    }

    private static void logout() {
        currUser = userController.logout();
        System.out.println("LOG-OUT-ED");
    }

    private static void showListUser() {
        List<User> users = userController.getUsers();

        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void createUser() {
        if (!currUser.isAdmin() || currUser == null) {
            System.out.println("you must be an admin!");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("create user:");
        System.out.print("fullname: ");
        String fullname = sc.nextLine();
        System.out.print("email: ");
        String email = sc.next();
        if (userController.createUser(fullname, email)) {
            System.out.println("create user: " + email);
        } else {
            System.out.println("cannot create user!");
        }
        ;
    }

    private static void showUserInfo() {
        if (currUser != null)
            System.out.println(currUser.toString());
        System.out.println("you are guest");
    }


}
