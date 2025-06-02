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

public class InboundShipment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "shipmentId",nullable = false,updatable = false)
    private  String shipmentId;

    @Column(name = "productTitle",nullable = false,updatable = false)
    private  String productTitle;

    @Column(name ="productWeight",nullable = false)
    private  double productWeight;

    @Column(name = "productLength",nullable = false)
    private  double productLength;

    @Column(name="productBreadth",nullable = false)
    private  double productBreadth;

    @Column(name = "materialType",nullable = false)
    private  String materialType;

    @Column(name = "careInstruction",nullable = false)
    private  String careInstruction;

    @Column(name = "quantity",nullable = false)
    private  int quantity;

    @Column(name = "productPrice",nullable = false)
    private double productPrice;

    @Column(name ="customerId",nullable = false,updatable = false)
    private String customerId;

    @CreatedDate
    @Column(name = "createdAt",nullable = false,updatable = false)
    private Instant createdAt;
    @Column(name = "status",nullable = false)
    private ShipmentStatus status;
    @ManyToOne
    private Warehouse warehouse;



}
