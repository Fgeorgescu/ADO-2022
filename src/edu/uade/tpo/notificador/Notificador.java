package edu.uade.tpo.notificador;

import edu.uade.tpo.notificador.strategy.Mensaje;
import edu.uade.tpo.notificador.strategy.NotificationStrategy;
import edu.uade.tpo.personas.Persona;

// Puede ser un singleton
public class Notificador {

  private NotificationStrategy strategy;

  public Notificador() {
  }

  public void setStrategy(NotificationStrategy strategy) {
    this.strategy = strategy;
  }

  public void enviar(Persona persona, String mensaje) {
    if (strategy == null) {
      System.out.println("No hay notificador seleccionado, por favor configure uno antes de enviar una notificación.");
    }

    strategy.enviar(new Mensaje(mensaje, persona));
  }
}
