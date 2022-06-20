package edu.uade.tpo.gastos;

import edu.uade.tpo.personas.Persona;

public class GastoUnico extends Gasto {

  public GastoUnico(String nombre, double monto, TipoExpensa tipoExpensa, Persona creador) {
    super(nombre, monto, tipoExpensa, creador);
  }
}
