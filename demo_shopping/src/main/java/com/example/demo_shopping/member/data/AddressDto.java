package com.example.demo_shopping.member.data;

import com.example.demo_shopping.member.entity.Address;
import com.example.demo_shopping.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class AddressDto {
  String address;

//  public Address toEntity(MemberDto memberDto) {
//    return Address.builder()
//        .member(memberDto.toEntity())
//        .addressData(this.address)
//        .build();
//  }

  public Address toEntity(Member member) {
    return Address.builder()
        .member(member)
        .addressData(this.address)
        .build();
  }

}
