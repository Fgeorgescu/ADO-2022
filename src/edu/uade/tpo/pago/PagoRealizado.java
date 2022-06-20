package edu.uade.tpo.pago;

import edu.uade.tpo.pago.estados.EstadoExpensa;
import edu.uade.tpo.pago.estados.PagoPendiente;
import java.time.LocalDateTime;

public class PagoRealizado {

  private EstadoExpensa estado;
  private double monto;

  private LocalDateTime fechaEmision;
  private LocalDateTime fechaPago;

  public PagoRealizado(double monto, LocalDateTime fechaEmisión) {
    this.monto = monto;
    this.fechaEmision = LocalDateTime.now();
    this.estado = new PagoPendiente(this);
  }

  public EstadoExpensa getEstado() {
    return estado;
  }

  public void setEstado(EstadoExpensa estado) {
    this.estado = estado;
  }

  public double getMonto() {
    return monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  public LocalDateTime getFechaPago() {
    return fechaPago;
  }

  public void setFechaPago(LocalDateTime fechaPago) {
    this.fechaPago = fechaPago;
  }
}
