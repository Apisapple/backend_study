package com.example.demo_shopping.item.entity;


import java.time.LocalDateTime;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
@DiscriminatorColumn(name = "ITEM TYPE")
public abstract class Item {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String brand;
  private String itemNumber;
  private String stockQuantity;

  private Integer price;
  private Long likePoint;
  private LocalDateTime lastModifiedTime;
  private LocalDateTime registrationTime;

  @PrePersist
  public void prePersist() {
    lastModifiedTime = LocalDateTime.now();
    registrationTime = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    lastModifiedTime = LocalDateTime.now();
  }
}
