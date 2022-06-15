package edu.uade.tpo.gestora;

import edu.uade.tpo.Consorcio;
import edu.uade.tpo.Periodo;
import edu.uade.tpo.UnidadFuncional;
import edu.uade.tpo.expensas.Expensa;
import edu.uade.tpo.gestora.criterios.CriterioPago;
import edu.uade.tpo.notificador.Notificador;
import edu.uade.tpo.pago.PagoRealizado;
import edu.uade.tpo.personas.Persona;
import edu.uade.tpo.utils.StrategyUtil;
import java.util.List;

// Puede ser singleton
public class Gestora {

  private CriterioPago criterioPago;
  private Consorcio consorcio;
  private Notificador notificador;

  public Gestora(Consorcio consorcio) {
    this.consorcio = consorcio;
  }

  void calcularExpensas(Persona administrador) {
    System.out.printf("Calculando expensas a pedido de %s%n", administrador.getNombre());

    // Usar this.consorsio;
    if (criterioPago == null) {
      System.out.println("Por favor, seleccione un criterio para calcular las expensas");
      return;
    }

    double gastoTotal = criterioPago.calcularGasto(consorcio.getPeriodoActivo());
    double saldoTotal = criterioPago.obtenerSaldo(consorcio.getCbu());

    for (UnidadFuncional uf: consorcio.getUnidadesFuncionales()) {

      double montoExpensa = criterioPago.divisionExpensas(uf, gastoTotal, saldoTotal);

      // El nombre PagoRealizado quedó confuso.
      PagoRealizado expensa = new PagoRealizado(montoExpensa);

      notificar(uf.getPropietarios(), expensa);
      notificar(uf.getInquilinos(), expensa);
    }

  }

  private void notificar(List<Persona> personas, PagoRealizado expensa) {
    for (Persona p : personas) {
      notificador.setStrategy(StrategyUtil.getNotificationStrategy(p.getDefecto().getTipoNotificacion()));

      // Se puede agregar cuando vence, cuando se generó, etc etc etc
      notificador.enviar(p, "Se registró una nueva expensa por el monto de: " + expensa.getMonto());
    }
  }

  void seleccionarCriterioPago(CriterioPago criterioPago) {
    this.criterioPago = criterioPago;
  }
}
