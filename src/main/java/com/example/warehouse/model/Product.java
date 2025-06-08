package com.example.warehouse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @Column(name = "productid",nullable = false,updatable = false)
    private String productId;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "price",nullable = false)
    private double price;

    @Column(name = "material",nullable = false)
    private String material;

    @Column(name = "length" ,nullable = false)
    private double length;

    @Column(name = "care_instruction",nullable = false,updatable = false,length = 2000)
    private String careInstruction;

    @Column(name = "breadth",nullable = false)
    private double breadth;

    @Column(name = "height",nullable = false)
    private double height;

    @Column(name = "weight",nullable = false)
    private double weight;
}
