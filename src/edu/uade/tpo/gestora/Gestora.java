package edu.uade.tpo.gestora;

import edu.uade.tpo.Consorcio;
import edu.uade.tpo.UnidadFuncional;
import edu.uade.tpo.gestora.criterios.CriterioPago;
import edu.uade.tpo.notificador.Notificador;
import edu.uade.tpo.pago.PagoRealizado;
import edu.uade.tpo.pagos.Pago;
import edu.uade.tpo.personas.Persona;
import edu.uade.tpo.utils.LogUtil;
import edu.uade.tpo.utils.SessionUtils;
import edu.uade.tpo.utils.StrategyUtil;


// Puede ser singleton
public class Gestora {

  private CriterioPago criterioPago;
  private Consorcio consorcio;
  private Persona administrador;
  public Gestora(Consorcio consorcio) {
    this.consorcio = consorcio;
    this.administrador = SessionUtils.getLoggedAdministrator();
  }

  public void calcularExpensas() {
    System.out.printf("Calculando expensas a pedido de %s%n", administrador.getNombre());

    if (criterioPago == null) {
      System.out.println("Por favor, seleccione un criterio para calcular las expensas");
      return;
    }

    criterioPago.divisionExpensas(consorcio);

    // Como calculamos las expensas, abrimos un nuevo periodo
    consorcio.abrirPeriodo();
  }



  public void seleccionarCriterioPago(CriterioPago criterioPago) {
    new LogUtil().logMessage("se seleccionó %s como criterio de pago", criterioPago.getClass().getSimpleName());
    this.criterioPago = criterioPago;

  }
}
