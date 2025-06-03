package com.example.warehouse.model;

import com.example.warehouse.enums.ShipmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "inbound_shipment")
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)

public class InboundShipment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "shipmentId",nullable = false,updatable = false)
    private  String shipmentId;

    @Column(name ="sellerId",nullable = false,updatable = false)
    private String SellerId;

    @CreatedDate
    @Column(name = "createdAt",nullable = false,updatable = false)
    private Instant createdAt;

    @Column(name = "status",nullable = false)
    private ShipmentStatus status;

    @Column(name = "quantity",nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;



}
