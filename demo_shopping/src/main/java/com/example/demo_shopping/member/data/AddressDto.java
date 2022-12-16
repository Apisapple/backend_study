package com.example.demo_shopping.member.data;

import com.example.demo_shopping.member.entity.Address;
import com.example.demo_shopping.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class AddressDto {
  String address;

  @Builder
  public AddressDto(String address) {
    this.address = address;
  }


  public Address toEntity(Member member) {
    return Address.builder()
        .member(member)
        .addressData(this.address)
        .build();
  }

  @Override
  public String toString() {
    return "AddressDto{" +
        "address='" + address + '\'' +
        '}';
  }
}
