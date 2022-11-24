package com.example.demo_shopping.member.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Address extends BasicEntity {

  @ManyToOne(fetch = FetchType.EAGER)
  private Member member;
  private String address;
}
