package edu.uade.tpo.gastos;

import edu.uade.tpo.personas.Persona;

public class GastoRecurrente extends Gasto {

  public GastoRecurrente(String nombre, double monto, TipoExpensa tipoExpensa, Persona creador) {
    super(nombre, monto, tipoExpensa, creador);
  }

  // Hacemos override del equals para que se puedan validar gastos recurrentes duplicados.

}
