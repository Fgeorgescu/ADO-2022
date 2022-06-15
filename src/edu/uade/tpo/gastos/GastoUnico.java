package edu.uade.tpo.gastos;

import edu.uade.tpo.personas.Persona;

public class GastoUnico extends Gasto{

  public GastoUnico(TipoGasto tipoGasto, double monto, TipoExpensa tipoExpensa, Persona creador) {
    super(tipoGasto, monto, tipoExpensa, creador);
  }
}
