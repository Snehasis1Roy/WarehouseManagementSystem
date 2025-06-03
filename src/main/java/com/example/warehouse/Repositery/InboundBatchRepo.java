package com.example.warehouse.Repositery;

import com.example.warehouse.model.InboundBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface InboundBatchRepo extends JpaRepository<InboundBatch,String> {
}
