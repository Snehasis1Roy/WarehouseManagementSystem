package com.example.warehouse.model;

import com.example.warehouse.enums.BlockType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "blocks")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity

public class Block {
    @ManyToOne
    private  Rooms rooms;

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String blockId;
    @Column(name = "blockType",nullable = false,updatable = false)
    private BlockType blockType;
    @Column(name = "length",nullable = false)
    private double length;
    @Column(name = "bredth",nullable = false)
    private double bredth;
    @Column(name = "height",nullable = false)
    private double height;
}
