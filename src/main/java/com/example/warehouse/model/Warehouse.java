package com.example.warehouse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Setter
@Getter
@Table(name = "warehouse")
@Inheritance(strategy = InheritanceType.JOINED)
public class Warehouse {

    @OneToMany(mappedBy = "warehouse")
    private List<Admin> admin;

    @OneToMany(mappedBy = "warehouse")
    private List<Staff> staff;

    @OneToMany(mappedBy = "warehouse")
    private List<Rooms> rooms;

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "WarehouseId",nullable = false,updatable = false)
    private String warehouseId;

    @Column(name = "warehouseName",nullable = false)
    private String warehouseName;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "city",nullable = false,updatable = false)
    private String city;

    @Column(name = "landmark",nullable = false)
    private String landmark;
}
