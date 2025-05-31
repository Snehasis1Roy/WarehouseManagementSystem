package com.example.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Admin extends User {
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
}
