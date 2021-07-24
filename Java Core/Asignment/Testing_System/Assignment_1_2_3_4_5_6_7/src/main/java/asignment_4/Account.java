package asignment_4;

public class Account {
    private String id;
    private String name;
    private int balance;

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        balance -= amount;
        return 1;
    }

    public int debit(int amount) {
        this.balance += amount;
        return 1;
    }

    public int tranferTo(Account account, int amount) {
        if(this.balance>=amount){
            this.balance-=amount;
            return 1;
        }
        return 0;
    }
}
