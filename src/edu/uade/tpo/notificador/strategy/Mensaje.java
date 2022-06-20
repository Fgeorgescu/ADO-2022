package edu.uade.tpo.notificador.strategy;

import edu.uade.tpo.personas.Persona;

public class Mensaje {
  String mensaje;
  Persona persona;

  public Mensaje(String mensaje, Persona persona) {
    this.mensaje = mensaje;
    this.persona = persona;
  }

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }
}
