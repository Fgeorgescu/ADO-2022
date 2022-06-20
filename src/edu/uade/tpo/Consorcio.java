package edu.uade.tpo;

import edu.uade.tpo.gastos.Gasto;
import edu.uade.tpo.gastos.GastoRecurrente;
import edu.uade.tpo.gastos.GastoUnico;
import edu.uade.tpo.gastos.TipoExpensa;
import edu.uade.tpo.gastos.TipoGasto;
import edu.uade.tpo.personas.Persona;
import edu.uade.tpo.utils.SessionUtils;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Consorcio {

  private String idConsorcio;
  private CuentaBancaria cuentaBancaria;
  private List<UnidadFuncional> unidadesFuncionales;
  private List<Periodo> periodos;
  private Periodo periodoActivo;
  private List<Gasto> gastosRecurrentes;

  public Consorcio(String idConsorcio, CuentaBancaria cuentaBancaria) {
    this.idConsorcio = idConsorcio;
    this.cuentaBancaria = cuentaBancaria;
    unidadesFuncionales = new ArrayList<>();
    periodos = new ArrayList<>();
    gastosRecurrentes = new ArrayList<>();
  }

  /**
   * Guarda el último periodo activo en el historial y crea un nuevo periodo activo.
   * Esto introduce la posibilidad de agregar estados al periodo
   * (por ejemplo activo, pendienteCalculo, cobroIncompleto, cobro completo, etc.)
   */
  void abrirPeriodo() {
    if (periodoActivo != null) periodos.add(this.periodoActivo);

    periodoActivo = new Periodo(LocalDateTime.now().getMonth(), LocalDateTime.now().getYear());

    for (Gasto gasto : gastosRecurrentes) {
      periodoActivo.agregarGasto(gasto);
    }
  }

  void agregarGastoUnico(double monto, TipoExpensa tipoExpensa) {
    Persona persona = SessionUtils.getLoggedAdministrator();

    periodoActivo.agregarGasto(new GastoUnico(monto, tipoExpensa, persona));
  }


  void agregarGastoRecurrente(double monto, TipoExpensa tipoExpensa) {
    Persona persona = SessionUtils.getLoggedAdministrator();

    Gasto gastoRecurrente = new GastoRecurrente(monto, tipoExpensa, persona);
    if (this.gastosRecurrentes.contains(gastoRecurrente)) {
      System.out.println("Ya se encontró un gasto con las mismas caracteristicas. Evitamos duplicados");
    }
    this.gastosRecurrentes.add(gastoRecurrente);
    this.periodoActivo.agregarGasto(gastoRecurrente);
  }

  public Periodo getPeriodoActivo() {
    return periodoActivo;
  }
}
