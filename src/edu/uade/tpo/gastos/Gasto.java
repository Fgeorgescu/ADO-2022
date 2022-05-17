package edu.uade.tpo.gastos;

import edu.uade.tpo.personas.Persona;

public abstract class Gasto {
  private TipoGasto tipoGasto;
  private double monto;
  private TipoExpensa tipoExpensa;
  private Persona creador;

  public Gasto(TipoGasto tipoGasto, double monto, TipoExpensa tipoExpensa, Persona creador) {
    this.tipoGasto = tipoGasto;
    this.monto = monto;
    this.tipoExpensa = tipoExpensa;
    this.creador = creador;
  }


}
