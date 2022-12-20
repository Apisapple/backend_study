package com.example.demo_shopping.member.entity;

import com.example.demo_shopping.member.data.AddressDto;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Address extends BasicEntity {

  @ManyToOne(fetch = FetchType.EAGER)
  private Member member;
  private String addressData;

  public AddressDto toDto() {
    return AddressDto.builder().address(this.addressData).build();
  }

  @Builder
  public Address(Member member, String addressData) {
    this.member = member;
    this.addressData = addressData;
  }
}
