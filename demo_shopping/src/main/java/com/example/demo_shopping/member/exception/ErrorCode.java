package com.example.demo_shopping.member.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  // MEMBER ERROR
  CANNOT_FOUND_MEMBER("CANNOT_FOUND_MEMBER", 1000000),
  ALREADY_EXIST_MEMBER("ALREADY_EXIST_MEMBER", 1000001),


  // ADDRESS ERROR
  ADDRESS_MUST_LEAST_ONE("ADDRESS_MUST_LEAST_ONE", 2000000);

  private final String msg;
  private final int code;
}
