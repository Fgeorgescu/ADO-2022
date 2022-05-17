package edu.uade.tpo.gastos;

import edu.uade.tpo.personas.Persona;

public class GastoRecurrente extends Gasto {

  public GastoRecurrente(TipoGasto tipoGasto, double monto, TipoExpensa tipoExpensa, Persona creador) {
    super(tipoGasto, monto, tipoExpensa, creador);
  }
}
