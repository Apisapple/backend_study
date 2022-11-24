package com.example.demo_shopping.member.entity;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
public class Member extends BasicEntity {

  private String name;
  private String email;
  private String password;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "member")
  private List<Address> addresses;

}
