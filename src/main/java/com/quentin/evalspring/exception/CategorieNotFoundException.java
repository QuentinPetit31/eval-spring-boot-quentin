package com.quentin.evalspring.exception;

public class CategorieNotFoundException extends RuntimeException {
  public CategorieNotFoundException(String message) {
    super(message);
  }
}
