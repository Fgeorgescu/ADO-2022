package edu.uade.tpo;

import java.util.List;

public class Consorcio {

  private String idConsorcio;
  private CuentaBancaria cuentaBancaria;
  private List<UnidadFuncional> unidadesFuncionales;
  private List<Periodo> periodos;

  public Consorcio(String idConsorcio, CuentaBancaria cuentaBancaria) {
    this.idConsorcio = idConsorcio;
    this.cuentaBancaria = cuentaBancaria;
  }
}
