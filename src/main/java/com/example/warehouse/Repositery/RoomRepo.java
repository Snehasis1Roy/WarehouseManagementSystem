package com.example.warehouse.Repositery;

import com.example.warehouse.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Rooms,String> {
}
