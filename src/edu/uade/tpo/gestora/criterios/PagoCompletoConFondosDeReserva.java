package edu.uade.tpo.gestora.criterios;

import edu.uade.tpo.UnidadFuncional;

// Puede ser singleton
public class PagoCompletoConFondosDeReserva extends CriterioPago {
  @Override
  public double divisionExpensas(UnidadFuncional unidadFuncional, double gasto, double saldo) {
    double mora = gasto - saldo;
    // TODO: Devolver mora / %UF en caso de que gasto > mora.
    return 0;
  }
}
