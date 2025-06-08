package com.example.warehouse.Repositery;

import com.example.warehouse.model.Rack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackRepo extends JpaRepository<Rack,String> {
}
