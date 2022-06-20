package edu.uade.tpo.gestora.criterios;

import edu.uade.tpo.Consorcio;
import edu.uade.tpo.UnidadFuncional;
import edu.uade.tpo.notificador.Notificador;
import edu.uade.tpo.pagos.Pago;

import java.util.function.Function;

// Puede ser singleton
public class PagoCompletoConFondosDeReserva extends CriterioPago {
  @Override
  public void divisionExpensas(Consorcio consorcio) {

    double saldo = obtenerSaldo(consorcio.getCuentaBancaria());
    double gasto = calcularGasto(consorcio.getPeriodoActivo());
    double totalAPagar = gasto - saldo;

    for (UnidadFuncional uf: consorcio.getUnidadesFuncionales()) {
      double porcentaje = uf.getPocentajeDePago();

      double montoExpensa = Math.max(totalAPagar, 0) * porcentaje;

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
