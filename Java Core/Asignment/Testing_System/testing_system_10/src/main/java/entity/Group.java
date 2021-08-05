package entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Group {
    private int id;
    private String name;
    private Account creator;
    private LocalDate createDate;
    public List<Account> accounts;
}
