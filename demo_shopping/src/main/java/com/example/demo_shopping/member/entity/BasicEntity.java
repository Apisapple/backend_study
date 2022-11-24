package com.example.demo_shopping.member.entity;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@MappedSuperclass
@ToString
public class BasicEntity {

  @Id
  @GeneratedValue
  private Long id;

  private LocalDateTime lastModifiedTime;
}
