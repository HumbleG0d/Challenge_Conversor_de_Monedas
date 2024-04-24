package org.view.Logic;

public class Converter {

  public double convertir(double cantidad, double valor_moneda_destino , double valor_moneda_origen) {
    return (valor_moneda_destino / valor_moneda_origen) * cantidad;
  }

}
