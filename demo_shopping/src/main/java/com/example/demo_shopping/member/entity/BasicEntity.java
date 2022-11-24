package com.example.demo_shopping.member.entity;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.asm.Advice.Local;

@Getter
@Setter
@MappedSuperclass
@ToString
public class BasicEntity {

  @Id
  @GeneratedValue
  private Long id;

  private LocalDateTime lastModifiedTime;

  @PrePersist
  public void prePersist() {
    lastModifiedTime = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    lastModifiedTime = LocalDateTime.now();
  }
}
