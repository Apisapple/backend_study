package com.example.demo_shopping.member.data;

import com.example.demo_shopping.member.entity.Address;
import com.example.demo_shopping.member.entity.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {

  private String name;
  private String email;
  private String password;

  private List<AddressDto> addresses;

  @Builder
  public MemberDto(String name, String email, String password, List<AddressDto> addresses) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.addresses = addresses;
  }

  public Member toEntity() {
    List<Address> addressList = new ArrayList<>();

    for (AddressDto address : this.addresses) {
      addressList.add(Address.builder().addressData(address.getAddress()).build());
    }

    return Member.builder()
        .name(this.name)
        .email(this.email)
        .password(this.password)
        .addresses(addressList)
        .build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MemberDto memberDto = (MemberDto) o;
    return name.equals(memberDto.name) && email.equals(memberDto.email) && password.equals(memberDto.password)
        && Objects.equals(addresses, memberDto.addresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, password, addresses);
  }
}
