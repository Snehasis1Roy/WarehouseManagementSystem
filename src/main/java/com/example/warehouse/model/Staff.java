package com.example.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Staff extends User {
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

}
