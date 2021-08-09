package entity;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter @Setter
final public class Employee extends User{
    public List<String> proSkill;

    public Employee(int id, String fullname, String email, String password, List<String> proSkill) {
        super(id, fullname, email, password);
        this.proSkill = proSkill;
    }

    public Employee(List<String> proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "proSkill=" + proSkill +
                ", id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
