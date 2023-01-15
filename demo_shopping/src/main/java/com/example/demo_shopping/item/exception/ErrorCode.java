package com.example.demo_shopping.item.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  CANNOT_FOUND_ITEM("CANNOT_FOUND_ITEM", 3000000),
  ALREADY_EXIST_ITEM("ALREADY_EXIST_ITEM", 3000001);

  private final String msg;
  private final int code;
  }
