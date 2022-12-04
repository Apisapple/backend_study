package com.example.demo_shopping.member.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  // MEMBER ERROR
  CANNOT_FOUND_MEMBER("CANNOT_FOUND_MEMBER", 100000),
  ALREADY_EXIST_MEMBER("ALREADY_EXIST_MEMBER", 100001);

  private final String msg;
  private final int code;
}
