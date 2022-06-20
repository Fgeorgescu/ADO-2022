package edu.uade.tpo.gestora.criterios;

import edu.uade.tpo.Periodo;
import edu.uade.tpo.UnidadFuncional;

public abstract class CriterioPago {

  public double calcularGasto(Periodo periodo) {
    // TODO: Iterar por el período y calcular gastos
    return 0.0;
  }

  public double obtenerSaldo(String cbu) {
    // TODO: Iterar por el período y calcular gastos
    return 0.0;
  }
  public abstract double divisionExpensas(UnidadFuncional unidadFuncional, double gasto, double saldo);
}
