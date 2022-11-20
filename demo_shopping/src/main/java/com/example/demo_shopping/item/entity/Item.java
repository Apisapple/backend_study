package com.example.demo_shopping.item.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

  private Long id;
  private Integer categoryNumber;
  private String modelNumber;
  private Integer reviewPoint;
  private String name;
  private Integer price;
  private String img;
}
