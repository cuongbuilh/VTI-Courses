package app;

import entity.User;

public class Application {
    private static User currUser;
    private static functions myFunc;

    public static void main(String[] args) {
        myFunc = new functions();
        currUser = null;
        int selection=0;

        do {
            myFunc.printMenu(currUser);
            selection = myFunc.getSelection();
            currUser =  myFunc.process(currUser, selection);
        }while (selection == Configs.EXIT);
    }

}
