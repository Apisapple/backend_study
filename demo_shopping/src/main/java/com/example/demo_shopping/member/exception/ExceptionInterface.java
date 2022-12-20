package com.example.demo_shopping.member.exception;

public interface ExceptionInterface {

  default int getCode() {
    return 999999;
  }
}
