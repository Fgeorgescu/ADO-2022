package edu.uade.tpo.pago.estados;

import edu.uade.tpo.pago.PagoRealizado;
import java.time.LocalDateTime;

public class PagoPendiente implements EstadoExpensa {

  private PagoRealizado contexto;

  public PagoPendiente(PagoRealizado contexto) {
    this.contexto = contexto;
  }

  @Override
  public void generarIntereses() {
    // Set del nuevo monto del contexto, puede ser con historial o no
    this.contexto.setMonto(this.contexto.getMonto() * INTERES_MENSUAL);
    System.out.printf("El nuevo saldo a pagar es %s", this.contexto.getMonto());
    this.contexto.setEstado(new PagoVencido(this.contexto));
  }

  @Override
  public void saldar() {
    contexto.setEstado(new PagoConcretado(this.contexto));
    this.contexto.setFechaPago(LocalDateTime.now());
  }
}
