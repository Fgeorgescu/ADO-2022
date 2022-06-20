package edu.uade.tpo.pago.estados;

public interface EstadoExpensa {
  double INTERES_MENSUAL = 1.01;

  void generarIntereses();
  void saldar();
}
