package com.example.demo_shopping.member.entity;


import com.example.demo_shopping.member.data.AddressDto;
import com.example.demo_shopping.member.data.MemberDto;
import java.util.List;
import java.util.stream.Collectors;
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
  public Member(String name, String email, String password, List<Address> addresses) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.addresses = addresses;
  }

  public Member updateMember(MemberDto memberDto) {
    this.name = memberDto.getName();
    this.password = memberDto.getPassword();
    this.addresses = memberDto.getAddresses().stream()
        .map(addressDto -> addressDto.toEntity(this))
        .collect(Collectors.toList());
    return this;
  }

  public void addAddress(Address address) {
    this.addresses.add(address);
    address.setMember(this);
  }
}
