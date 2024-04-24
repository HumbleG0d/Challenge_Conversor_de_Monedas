package org.view.Core;

public class Coins {
  private String code; // USD, EUR, GBP, etc
  private double value; // 1 USD = 1.0, 1 EUR = 1.2, 1 GBP = 1.4, etc

  // Constructor
  public Coins(String code, double value) {
    this.code = code;
    this.value = value;
  }

  // Getters
  public String getCode() {
    return code;
  }

  // Getters
 public double getValue() {
    return value;
  }
}
