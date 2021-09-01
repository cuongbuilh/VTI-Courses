package com.myproject.springproject.entity;


import com.myproject.springproject.entity.converter.PositionNameConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
