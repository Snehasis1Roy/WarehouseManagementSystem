package com.example.warehouse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "rooms")
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
public class Rooms {
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @OneToMany(mappedBy = "rooms")
    private List<Block> blocks;

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private String roomId;
    private String roomName;
}
