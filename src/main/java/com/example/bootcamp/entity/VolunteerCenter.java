package com.example.bootcamp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="volunteer")
public class VolunteerCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name="Coordinate_x")
    private float coordinate_x;

    @Column(name="Coordinate_y")
    private float coordinate_y;
}
