package com.example.demo_shopping.item.exception;

public class ItemErrorException extends Exception {

  private final int code;

  public ItemErrorException(String msg, int code) {
    super(msg);
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
