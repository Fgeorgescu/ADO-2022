package edu.uade.tpo;

import edu.uade.tpo.expensas.Expensa;
import edu.uade.tpo.personas.Persona;
import java.util.ArrayList;
import java.util.List;

public class UnidadFuncional {

  private double pocentajeDePago;
  private List<Persona> propietarios;
  private List<Persona> inquilinos;
  private List<Expensa> expensas;

  public UnidadFuncional(double pocentajeDePago, List<Persona> propietarios) {
    this.pocentajeDePago = pocentajeDePago;
    this.propietarios = propietarios;
    this.inquilinos = new ArrayList<>();
    this.expensas = new ArrayList<>();
  }

  public void agregarInquilino(Persona inquilino) {
    inquilinos.add(inquilino);
  }

  public void sacarInquilino(String name) {
    inquilinos.removeIf(i -> i.getNombre().equalsIgnoreCase(name));
  }

  public void sacarInquilino(Persona inquilino) {
    inquilinos.removeIf(i -> i.getNombre().equalsIgnoreCase(inquilino.getNombre()));
  }
}
