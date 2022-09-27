package com.jovan_bojovic.spring_assignment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "HELLO")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Hello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name = "CURRENT")
    private String CURRENT;

    @Column(name = "LANG")
    private String LANG;

}
