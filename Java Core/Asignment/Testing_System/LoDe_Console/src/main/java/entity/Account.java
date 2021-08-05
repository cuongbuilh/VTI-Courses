package entity;

import exception.PermissonDeniedException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class Account implements Serializable {
    final private int id;
    private String name;
    private String username;
    private String password;
    private long amount;

    private List<Rule> rules;

    public Account(int id) {
        this.id = id;
    }

    public Account(int id, String name, String username, String password, long amount) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.amount = amount;
        this.rules = new ArrayList<>();
        rules.add(Rule.USER);
    }

    public Account(int id, String name, long amount) {
        if (amount < 0) amount = 0;
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.rules = new ArrayList<>();
        rules.add(Rule.USER);
    }

    public Account(int id, String name, String username, String password, long amount, List<Rule> rules) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.amount = amount;
        this.rules = rules;
    }

    public void addMoney(long amount) {
        this.amount += amount;
    }

    public void subMoney(long amount) {
        this.amount -= amount;
    }

}
