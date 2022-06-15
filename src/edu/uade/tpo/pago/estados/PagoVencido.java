package edu.uade.tpo.pago.estados;

import edu.uade.tpo.pago.PagoRealizado;
import java.time.LocalDateTime;

public class PagoVencido implements EstadoExpensa {

  private PagoRealizado contexto;

  public PagoVencido(PagoRealizado contexto) {
    this.contexto = contexto;
  }

  @Override
  public void generarIntereses() {
    this.contexto.setMonto(this.contexto.getMonto() * INTERES_MENSUAL);
    System.out.printf("El nuevo saldo a pagar es %s", this.contexto.getMonto());
  }

  @Override
  public void saldar() {
    contexto.setEstado(new PagoConcretado(this.contexto));
    this.contexto.setFechaPago(LocalDateTime.now());
  }
}
