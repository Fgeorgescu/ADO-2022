package edu.uade.tpo.pago.estados;

import edu.uade.tpo.pago.PagoRealizado;
import java.time.format.DateTimeFormatter;

public class PagoConcretado implements EstadoExpensa {

  PagoRealizado contexto;

  public PagoConcretado(PagoRealizado contexto) {
    this.contexto = contexto;
  }

  @Override
  public void generarIntereses() {
    System.out.println("No puedes generar intereses de un pago ya realizado");
  }

  @Override
  public void saldar() {
    System.out.println("El pago fue concretado el d\u00eda %s"
        + this.contexto.getFechaPago().format(DateTimeFormatter.ofPattern("yyyy MM dd")));
  }
}
