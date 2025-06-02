package com.example.warehouse.dto.request;

public record ProductRequest (
  String title,
  double weight,
  double length,
  double height,
  double bredth,
  String materialType,
  String careinstruction,
  int    Quantity,
  double productPrice
){
}
