package edu.uade.tpo.personas;

public class Persona {
  private String email;
  private int telefono;

  private String name;

  public Persona(String email, int telefono) {
    this.email = email;
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getTelefono() {
    return telefono;
  }

  public void setTelefono(int telefono) {
    this.telefono = telefono;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
