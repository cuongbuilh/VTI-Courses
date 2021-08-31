package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Address", catalog = "TestingSystem2")
public class Address implements Serializable {
   @Id
   @Column(name = "AddressID")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

   @Column(name = "AddressName")
    private String address;

    @OneToOne(mappedBy = "address")
    private DetailDepartment department;
}
