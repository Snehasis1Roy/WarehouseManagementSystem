package com.example.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "rackedBlock")
@Getter
@Setter
@Entity
public class RackedBlock extends Block {
    @OneToMany(mappedBy = "rackedBlock")
    private List<Rack> rack;

}
