package com.example.demo_shopping.member.data;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberJoinResponseData {

  private Long id;
  private String name;
  private String email;
  private String password;
}
