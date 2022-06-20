package edu.uade.tpo;

import edu.uade.tpo.pagos.Pago;
import edu.uade.tpo.personas.Persona;
import java.util.ArrayList;
import java.util.List;

public class UnidadFuncional {


  private double pocentajeDePago;
  private List<Persona> propietarios;
  private List<Persona> inquilinos;
  private List<Pago> pagos;

  public UnidadFuncional(double pocentajeDePago, List<Persona> propietarios) {
    this.pocentajeDePago = pocentajeDePago;
    this.propietarios = propietarios;
    this.inquilinos = new ArrayList<>();
    this.pagos = new ArrayList<>();
  }

  public double getPocentajeDePago() {
    return pocentajeDePago;
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

  public List<Persona> getPropietarios() {
    return propietarios;
  }

  public List<Persona> getInquilinos() {
    return inquilinos;
  }

  public void agregarPago(Pago pago) {
    this.pagos.add(pago);
  }
}
