package com.shopping.shoppingbackend.util;

import com.shopping.shoppingbackend.exception.RequestException;

public class ValidateUtil {

  private ValidateUtil() {
    throw new IllegalStateException("Utility class");
  }

  public static void isNotNull(Object data, String message) throws RequestException {
    if (data == null)
      throw new RequestException(message);
  }

  public static void isTrue(boolean data, String message) throws RequestException {
    if (!data)
      throw new RequestException(message);
  }

}
