package edu.uade.tpo.gastos;

import edu.uade.tpo.personas.Persona;

public class GastoUnico extends Gasto {

  public GastoUnico(double monto, TipoExpensa tipoExpensa, Persona creador) {
    super(monto, tipoExpensa, creador);
  }
}
