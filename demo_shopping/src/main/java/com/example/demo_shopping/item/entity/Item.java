package com.example.demo_shopping.item.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
public class Item {

  @Id
  @GeneratedValue
  private Long id;
  private Integer categoryNumber;
  private String modelNumber;
  private Integer reviewPoint;
  private String name;
  private Integer price;
  private String img;
  private Double discountPercent;

}
