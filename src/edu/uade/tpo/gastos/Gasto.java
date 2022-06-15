package edu.uade.tpo.gastos;

import edu.uade.tpo.personas.Persona;
import java.util.Objects;

public abstract class Gasto {
  private double monto;
  private TipoExpensa tipoExpensa;
  private Persona creador;

  public Gasto(double monto, TipoExpensa tipoExpensa, Persona creador) {
    this.monto = monto;
    this.tipoExpensa = tipoExpensa;
    this.creador = creador;
  }

  public double getMonto() {
    return monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  public TipoExpensa getTipoExpensa() {
    return tipoExpensa;
  }

  public void setTipoExpensa(TipoExpensa tipoExpensa) {
    this.tipoExpensa = tipoExpensa;
  }

  public Persona getCreador() {
    return creador;
  }

  public void setCreador(Persona creador) {
    this.creador = creador;
  }

  // Hacemos override del equals para que se puedan validar gastos recurrentes duplicados.
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Gasto gasto = (Gasto) o;
    return Double.compare(gasto.monto, monto) == 0 && tipoExpensa == gasto.tipoExpensa;
  }
}
