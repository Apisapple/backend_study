package com.example.demo_shopping.member.data;

import com.example.demo_shopping.member.entity.Member;
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

  public Member toEntity() {
    return Member.builder()
        .name(this.name)
        .email(this.email)
        .password(this.password)
        .build();
  }
}
