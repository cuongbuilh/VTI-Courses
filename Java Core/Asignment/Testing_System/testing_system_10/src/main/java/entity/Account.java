package entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class Account {
    public int id;
    public String email;
    public String userName;
    public String fullName;
    public Department department;
    public Position position;
    public Date createDate;
    public List<Group> groups;
}
