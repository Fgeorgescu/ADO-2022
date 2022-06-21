package edu.uade.tpo.gestora.criterios;

import edu.uade.tpo.Consorcio;
import edu.uade.tpo.CuentaBancaria;
import edu.uade.tpo.Periodo;
import edu.uade.tpo.UnidadFuncional;
import edu.uade.tpo.gastos.Gasto;
import edu.uade.tpo.notificador.Notificador;
import edu.uade.tpo.pagos.Pago;
import edu.uade.tpo.personas.Persona;
import edu.uade.tpo.utils.StrategyUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class CriterioPago {
  private Notificador notificador;

  public CriterioPago() {
    this.notificador = new Notificador();
  }
  public double calcularGasto(Periodo periodo) {
    List<Gasto> gastos = periodo.obtenerGastos();
    return gastos.stream().reduce(0.0, (total,gasto)->
      total+gasto.getMonto(), Double::sum
    );
  }

  public double obtenerSaldo(CuentaBancaria cuenta) {
    return cuenta.consultarSaldo();
  }

  public abstract void divisionExpensas(Consorcio consorcio);

  void notificar(UnidadFuncional uf, Pago pago) {
    List<Persona> personasANotificar = new ArrayList<>(uf.getPropietarios());
    personasANotificar.addAll(uf.getInquilinos());

    for (Persona p : personasANotificar) {
      notificador.setStrategy(StrategyUtil.getNotificationStrategy(p.getDefecto().getTipoNotificacion()));

      // Se puede agregar cuando vence, cuando se generó, etc etc etc
      notificador.enviar(p, "Se registr\u00f3 una nueva expensa por el monto de: $" + pago.getMonto());
    }

    for (Persona p: uf.getInquilinos()) {

    }
  }

}
