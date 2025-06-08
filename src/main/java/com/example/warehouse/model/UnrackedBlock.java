package com.example.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
@Table(name = "unrackedBlock")
public class UnrackedBlock extends Block {
}
