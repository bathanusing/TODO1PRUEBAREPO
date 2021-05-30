package com.todo1.hulkstore.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum KeySize {
  AES128(128),
  DES168(168),
  RSA1024(1024),
  RSA2048(2048);

  @Getter
  private final int value;

}