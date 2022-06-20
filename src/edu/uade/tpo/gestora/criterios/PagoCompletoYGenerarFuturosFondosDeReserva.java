package edu.uade.tpo.gestora.criterios;

import edu.uade.tpo.Consorcio;
import edu.uade.tpo.UnidadFuncional;
import edu.uade.tpo.pagos.Pago;

// Puede ser singleton
public class PagoCompletoYGenerarFuturosFondosDeReserva extends CriterioPago {

  @Override
  public void divisionExpensas(Consorcio consorcio) {
    double gasto = calcularGasto(consorcio.getPeriodoActivo());

    for (UnidadFuncional uf: consorcio.getUnidadesFuncionales()) {
      double porcentaje = uf.getPocentajeDePago();

      double montoExpensa = gasto * porcentaje;
      double agregadoParaFondo = montoExpensa * 0.1;

      Pago pago = new Pago(montoExpensa + agregadoParaFondo);

      consorcio.getCuentaBancaria().agregarSaldo(agregadoParaFondo);

      uf.agregarPago(pago);
      notificar(uf, pago);
    }
  }
}
