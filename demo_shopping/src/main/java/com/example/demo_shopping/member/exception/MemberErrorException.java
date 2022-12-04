package com.example.demo_shopping.member.exception;

public class MemberErrorException extends Exception implements ExceptionInterface {
  private final int code;

  public MemberErrorException(String msg, int code) {
    super(msg);
    this.code = code;
  }

  @Override
  public int getCode() {
    return this.code;
  }
}
