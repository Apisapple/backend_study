package com.example.web_novel.user.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "member")
@Entity
@NoArgsConstructor
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Integer point;

  @Builder
  public Member(String name) {
    this.name = name;
    this.point = 0;
  }

  public void addPoint(Integer point) {
    this.point += point;
  }

  public void minusPoint(Integer point) {
    this.point = Math.max(this.point - point, 0);
  }
}
