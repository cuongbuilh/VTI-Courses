package entity;

import entity.converter.PositionNameConverter;
import entity.enums.PositionName;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "Position", catalog = "TestingSystem")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Position implements Serializable {
    @Id
    @Column(name = "PositionID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;


    @Column(name = "PositionName", nullable = false, unique = true)
    @Convert(converter = PositionNameConverter.class)
    private PositionName name;


    @OneToMany(mappedBy = "position")
    @ToString.Exclude
    private List<Account> accounts;


}
