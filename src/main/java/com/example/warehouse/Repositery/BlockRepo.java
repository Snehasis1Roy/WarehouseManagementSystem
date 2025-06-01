package com.example.warehouse.Repositery;

import com.example.warehouse.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepo extends JpaRepository<Block,String> {
}
