package edu.uade.tpo;

import edu.uade.tpo.pagos.Pago;
import edu.uade.tpo.personas.Persona;
import edu.uade.tpo.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class UnidadFuncional {


  private double pocentajeDePago;
  private List<Persona> propietarios;
  private List<Persona> inquilinos;
  private List<Pago> pagos;
  private String id;

  public UnidadFuncional(double pocentajeDePago, List<Persona> propietarios, String id) {
    this.id = id;
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

    new LogUtil().logMessage("se agreg\u00f3 al inquilino %s", inquilino.getNombre());
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

  public String getId() {
    return id;
  }
}
