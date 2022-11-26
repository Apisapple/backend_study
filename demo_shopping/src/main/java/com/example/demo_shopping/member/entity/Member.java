package com.example.demo_shopping.member.entity;


import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BasicEntity {

  private String name;
  private String email;
  private String password;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "member")
  private List<Address> addresses;

  @Builder
  public Member(Long id, String name, String email, String password, List<Address> addresses) {
    super(id);
    this.name = name;
    this.email = email;
    this.password = password;
    this.addresses = addresses;
  }
}
