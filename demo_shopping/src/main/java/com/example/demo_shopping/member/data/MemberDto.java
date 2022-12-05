package com.example.demo_shopping.member.data;

import com.example.demo_shopping.member.entity.Address;
import com.example.demo_shopping.member.entity.Member;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class MemberDto {

  private String name;
  private String email;
  private String password;

  private List<AddressDto> addresses;

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
}
