package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Account", catalog = "TestingSystem2")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private short id;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Username",length = 50,nullable = false, unique = true)
    private String username;

    @Column(name = "FirstName")
    private String firstname;

    @Column(name = "LastName")
    private String lastname;


    @ManyToOne
    @JoinColumn(name = "DepartmentID", nullable = false)
    private Department department;

    private LocalDateTime createDate;
}
