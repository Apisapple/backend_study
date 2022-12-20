package com.example.demo_shopping.member.exception;

public class AddressErrorException extends Exception implements ExceptionInterface {

  private final int code;

  public AddressErrorException(String msg, int code) {
    super(msg);
    this.code = code;
  }

  @Override
  public int getCode() {
    return code;
  }
}
