package edu.uade.tpo;

import edu.uade.tpo.gastos.Gasto;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Periodo {

  private List<Gasto> gastos;
  private Month mes;
  private int anio;

  public Periodo(Month mes, int anio) {
    this.mes = mes;
    this.anio = anio;
    this.gastos = new ArrayList<>();
  }

  public void agregarGasto(Gasto gasto) {
    this.gastos.add(gasto);
  }
  public List<Gasto> obtenerGastos() {
    return gastos;
  }
}
