package com.example.demo_shopping.member.entity;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class BasicEntity {

  @Id
  @GeneratedValue
  private Long id;

  private LocalDateTime lastModifiedTime;
  private LocalDateTime createTime;

  @PrePersist
  public void prePersist() {
    lastModifiedTime = LocalDateTime.now();
    createTime = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    lastModifiedTime = LocalDateTime.now();
  }

  public BasicEntity(Long id) {
    this.id = id;
    this.createTime = LocalDateTime.now();
    this.lastModifiedTime = LocalDateTime.now();
  }
}
