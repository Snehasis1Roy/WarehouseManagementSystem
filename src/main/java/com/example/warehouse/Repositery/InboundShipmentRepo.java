package com.example.warehouse.Repositery;

import com.example.warehouse.model.InboundShipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InboundShipmentRepo extends JpaRepository<InboundShipment,String> {
}
