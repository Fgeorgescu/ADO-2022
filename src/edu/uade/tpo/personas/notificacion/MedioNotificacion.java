package edu.uade.tpo.personas.notificacion;

public class MedioNotificacion {
  boolean defecto;
  TipoNotificacion tipoNotificacion;

  public MedioNotificacion(boolean defecto, TipoNotificacion tipoNotificacion) {
    this.defecto = defecto;
    this.tipoNotificacion = tipoNotificacion;
  }

  public boolean isDefecto() {
    return defecto;
  }

  public void setDefecto(boolean defecto) {
    this.defecto = defecto;
  }

  public TipoNotificacion getTipoNotificacion() {
    return tipoNotificacion;
  }
}
