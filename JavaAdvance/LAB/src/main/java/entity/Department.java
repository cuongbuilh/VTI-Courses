package entity;


import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Department", catalog = "TestingSystem")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Department implements Serializable {
    @Id
    @Column(name = "DepartmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "DepartmentName", nullable = false)
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Account> accounts;
}
