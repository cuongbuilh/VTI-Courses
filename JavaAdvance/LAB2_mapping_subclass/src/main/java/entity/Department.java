package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "Department", catalog = "TestingSystem2")
@Inheritance(strategy = InheritanceType.JOINED)
public class Department implements Serializable {
    @Id
    @Column(name = "DepartmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "DepartmentName", nullable = false)
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Account> accounts;
}
