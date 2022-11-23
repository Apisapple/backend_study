package com.example.demo_shopping.item.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Food extends Item {
  private String countryOfOrigin;
  private LocalDateTime expirationDate;
}
