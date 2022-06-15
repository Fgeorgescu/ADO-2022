package edu.uade.tpo.gestora;

import edu.uade.tpo.Consorcio;
import edu.uade.tpo.Periodo;
import edu.uade.tpo.gestora.criterios.CriterioPago;
import edu.uade.tpo.personas.Persona;

// Puede ser singleton
public class Gestora {

  private CriterioPago criterioPago;
  private Consorcio consorcio;

  public Gestora(Consorcio consorcio) {
    this.consorcio = consorcio;
  }

  void calcularExpensas(Persona administrador) {
    System.out.printf("Calculando expensas a pedido de %s%n", administrador.getName());

    // Usar this.consorsio;
    if (criterioPago == null) {
      System.out.println("Por favor, seleccione un criterio para calcular las expensas");
    } else {
      // TODO: Cambiar al último periodo del this.consorsio
      criterioPago.calcularGasto(new Periodo());
    }
  }

  void seleccionarCriterioPago(CriterioPago criterioPago) {
    this.criterioPago = criterioPago;
  }
}
