package edu.uade.tpo;

import edu.uade.tpo.gastos.Gasto;
import edu.uade.tpo.gastos.GastoRecurrente;
import edu.uade.tpo.gastos.GastoUnico;
import edu.uade.tpo.gastos.TipoExpensa;
import edu.uade.tpo.personas.Persona;
import edu.uade.tpo.utils.LogUtil;
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

  public Consorcio(String idConsorcio, int cbu, List<UnidadFuncional> unidadesFuncionales) {
    this.idConsorcio = idConsorcio;
    this.cuentaBancaria = new CuentaBancaria(cbu);
    this.unidadesFuncionales = unidadesFuncionales;
    periodos = new ArrayList<>();
    gastosRecurrentes = new ArrayList<>();
  }

  /**
   * Guarda el último periodo activo en el historial y crea un nuevo periodo activo.
   * Esto introduce la posibilidad de agregar estados al periodo
   * (por ejemplo activo, pendienteCalculo, cobroIncompleto, cobro completo, etc.)
   *
   * Toma los gastos recurrentes y los agrega al periodo activo
   */
  public void abrirPeriodo() {
    if (periodoActivo != null) periodos.add(this.periodoActivo);

    periodoActivo = new Periodo(LocalDateTime.now().getMonth(), LocalDateTime.now().getYear());

    for (Gasto gasto : gastosRecurrentes) {
      // Dada alguna propiedad del gasto recurrente, podemos filtrar si lo agregamos o no
      // Por ejemplo, si los gastos fueran bimestraoes, cuatrimestrales, podríamos validarlo acá
      periodoActivo.agregarGasto(gasto);
    }
  }

  /**
   * Añade gastos al periodo activo
   * @param monto
   * @param tipoExpensa
   */
  public void agregarGastoUnico(String nombre, double monto, TipoExpensa tipoExpensa) {
    if (periodoActivo == null) abrirPeriodo();
    Persona persona = SessionUtils.getLoggedAdministrator();

    periodoActivo.agregarGasto(new GastoUnico(nombre, monto, tipoExpensa, persona));

    new LogUtil().logMessage("se agregó gasto único '%s' con monto $%f al período activo", nombre, monto, tipoExpensa.name());
  }

  /**
   * Añade gastos recurrentes. Si no existen, se agregan al periodo activo tmbn
   * @param monto
   * @param tipoExpensa
   */
  public void agregarGastoRecurrente(String nombre, double monto, TipoExpensa tipoExpensa) {
    Persona persona = SessionUtils.getLoggedAdministrator();

    Gasto gastoRecurrente = new GastoRecurrente(nombre, monto, tipoExpensa, persona);
    if (this.gastosRecurrentes.contains(gastoRecurrente)) {
      System.out.println("Ya se encontró un gasto con las mismas caracteristicas. Evitamos duplicados");
      return;
    }
    agregarGastoUnico(nombre, monto, tipoExpensa);
    this.gastosRecurrentes.add(gastoRecurrente);


    new LogUtil().logMessage("se agregó gasto recurrente '%s' con monto $%f al período activo", nombre, monto);
  }

  /**
   * Devuelve el periodo activo
   * @return
   */
  public Periodo getPeriodoActivo() {
    return periodoActivo;
  }

  public List<UnidadFuncional> getUnidadesFuncionales() {
    return unidadesFuncionales;
  }

  public CuentaBancaria getCuentaBancaria() {
    return cuentaBancaria;
  }
}
