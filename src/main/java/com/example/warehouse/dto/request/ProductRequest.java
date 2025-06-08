package com.example.warehouse.dto.request;

public record ProductRequest (
  String productId,
  String title,
  double weight,
  double length,
  double height,
  double breadth,
  String material,
  String careInstruction,
  double price
){
}
