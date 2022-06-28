package com.mikejohn.lottery.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Winner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String city;

    @Column
    private int amount;
}
