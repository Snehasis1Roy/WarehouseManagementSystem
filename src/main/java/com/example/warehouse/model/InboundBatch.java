package com.example.warehouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "inbound_batch")
public class InboundBatch {
    @Id
    @Column(name = "batchCode",nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String batchCode;

    @Column(name = "rejectedUnit",nullable = false)
    private int countOfRejectedUnit;

    @Column(name = "acceptedUnit",nullable = false)
    private int countOfAcceptedUnit;

    @OneToMany
    @JoinColumn(name = "productUnit")
    private List<ProductUnit> productUnit;

}
