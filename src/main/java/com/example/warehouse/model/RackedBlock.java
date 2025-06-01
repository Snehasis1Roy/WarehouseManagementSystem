package com.example.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Table(name = "rackedBlock")
@Getter
@Setter
@Entity
public class RackedBlock extends Block {
}
