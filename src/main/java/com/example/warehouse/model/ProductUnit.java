package com.example.warehouse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "productUnit")
@Entity
public class ProductUnit {
    @Column(name = "unitId", nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String unitId;

    @Column(name = "location" )
    private String location;//ok

    @ManyToOne
    @JoinColumn(name = "inbound_shipment-id")
    private InboundShipment inboundShipment;//ok

    @ManyToOne
    @JoinColumn(name = "inbound_batch_id")
    private InboundBatch inboundBatch;//ok

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
