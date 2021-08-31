package entity;


import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Account", catalog = "TestingSystem")
@Getter @Setter
@NoArgsConstructor
public class Account implements Serializable {
    @Id
    @Column(name = "AccountID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Username", nullable = false, unique = true)
    private String username;

    @Column(name = "Fullname", nullable = false)
    private String fullname;

    @ManyToOne
    @JoinColumn(name = "DepartmentID", nullable = false)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PositionID", nullable = false)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Position position;


    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
