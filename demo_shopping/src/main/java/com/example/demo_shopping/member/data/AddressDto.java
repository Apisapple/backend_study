package com.example.demo_shopping.member.data;

import com.example.demo_shopping.member.entity.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class AddressDto {
  String address;

  public Address toEntity(MemberDto memberDto) {
    return Address.builder()
        .member(memberDto.toEntity())
        .address(this.address)
        .build();
  }
}
