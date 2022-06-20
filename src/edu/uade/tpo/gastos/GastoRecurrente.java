package edu.uade.tpo.gastos;

import edu.uade.tpo.personas.Persona;

public class GastoRecurrente extends Gasto {

  public GastoRecurrente(double monto, TipoExpensa tipoExpensa, Persona creador) {
    super(monto, tipoExpensa, creador);
  }

  // Hacemos override del equals para que se puedan validar gastos recurrentes duplicados.

}
