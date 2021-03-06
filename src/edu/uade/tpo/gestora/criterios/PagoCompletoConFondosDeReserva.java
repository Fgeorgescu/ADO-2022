package edu.uade.tpo.gestora.criterios;

import edu.uade.tpo.Consorcio;
import edu.uade.tpo.UnidadFuncional;
import edu.uade.tpo.notificador.Notificador;
import edu.uade.tpo.pagos.Pago;
import edu.uade.tpo.utils.LogUtil;

import java.util.function.Function;

// Puede ser singleton
public class PagoCompletoConFondosDeReserva extends CriterioPago {
  @Override
  public void divisionExpensas(Consorcio consorcio) {

    double saldo = obtenerSaldo(consorcio.getCuentaBancaria());
    double gasto = calcularGasto(consorcio.getPeriodoActivo());
    double totalAPagar = gasto - saldo;

    new LogUtil().logMessage("el saldo disponible es $%.2f", saldo);
    new LogUtil().logMessage("el gasto es $%.2f", gasto);
    new LogUtil().logMessage("el total a pagar es $%.2f", totalAPagar);

    for (UnidadFuncional uf: consorcio.getUnidadesFuncionales()) {
      double porcentaje = uf.getPocentajeDePago();

      double montoExpensa = Math.max(totalAPagar, 0) * porcentaje;

      new LogUtil().logMessage("el monto a pagar por %s es $%.2f", uf.getId(), montoExpensa);
      Pago pago = new Pago(montoExpensa);

      uf.agregarPago(pago);
      notificar(uf, pago);
    }

    if (gasto >= saldo) {
      consorcio.getCuentaBancaria().restarSaldo(saldo);
    } else {
      consorcio.getCuentaBancaria().restarSaldo(gasto);
    }
  }
}
