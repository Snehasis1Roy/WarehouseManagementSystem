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
    private BlockType blockType;
    private double length;
    private double bredth;
    private double height;
}
