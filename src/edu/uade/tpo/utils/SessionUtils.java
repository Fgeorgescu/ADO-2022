package edu.uade.tpo.utils;

import edu.uade.tpo.personas.Persona;

/**
 * Clase mock, representaría nuestro session manager. De este sacamos cual es el administrador que está loggeado,
 * para poder llevar trackeo de esto. Podría ser tmbn un parametro de netrada del controlador, etc.
 */
public class SessionUtils {

  public static Persona getLoggedAdministrator() {
    return new Persona("Administrador",
        "Hardcodeado",
        "administracion@consorsio.com",
        "+541100000000");
  }
}
