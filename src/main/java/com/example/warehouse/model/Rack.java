package com.example.warehouse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "rack")
@Getter
@Setter
public class Rack {
    @ManyToOne
    private RackedBlock rackedBlock;
    @Column(name = "rackId",nullable = false,updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String rackId;
    @Column(name = "length",nullable = false)
    private  double length;
    @Column(name = "bredth",nullable = false)
    private double bredth;
    @Column(name = "height",nullable = false)
    private double height;
}
