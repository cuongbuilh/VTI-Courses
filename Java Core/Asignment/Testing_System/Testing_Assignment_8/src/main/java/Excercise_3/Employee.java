package Excercise_3;

import java.util.List;

public class Employee {
    private int id;
    private String name;
    private List<? extends Number> salaries;

    public Employee(int id, String name, List<? extends Number> salaries) {
        this.id = id;
        this.name = name;
        this.salaries = salaries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<? extends Number> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<? extends Number> salaries) {
        this.salaries = salaries;
    }
}

