package edu.uade.tpo.personas;

import edu.uade.tpo.personas.notificacion.MedioNotificacion;
import edu.uade.tpo.personas.notificacion.TipoNotificacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Persona {
  private String email;
  private String telefono;

  private List<MedioNotificacion> mediosNotificacion = new ArrayList<>();

  private String nombre;
  private String apellido;
  public Persona(String nombre, String apellido, String email, String telefono) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  List<MedioNotificacion> getMediosNotificationDefecto() {
    List<MedioNotificacion> mediosPorDefecto =
            mediosNotificacion.stream().filter(MedioNotificacion::isDefecto).collect(Collectors.toList());
    return mediosPorDefecto;
  }

  public void agregarNotificacion(boolean defecto, TipoNotificacion tipoNotificacion) {
    // Si la nueva es por defecto, buscamos y eliminamos los otros por defecto.
    // Este MediosNotificación podría ser un nuevo componente que encapsule la búsqueda de medios por defecto, etc.
    // De esta manera aislamos aún más estas responsabilidades, y no quedan en Persona.

    //Code smell, vamos a tener este snippet duplicado, se soluciona con lo que comenté más arriba

    if (defecto) {
      List<MedioNotificacion> mediosPorDefecto = getMediosNotificationDefecto();

      for (MedioNotificacion mn : mediosPorDefecto) {
        mn.setDefecto(false);
      }

    }
    mediosNotificacion.add(new MedioNotificacion(defecto, tipoNotificacion));
  }

  public MedioNotificacion getDefecto() {
    List<MedioNotificacion> mediosPorDefecto = getMediosNotificationDefecto();

      return mediosPorDefecto.stream().findFirst().orElseThrow(
          () -> new RuntimeException("No hay medio por defecto.")
      );
    }
}
