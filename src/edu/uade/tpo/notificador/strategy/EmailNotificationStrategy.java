package edu.uade.tpo.notificador.strategy;

import edu.uade.tpo.notificador.email.AdapterEmail;
import edu.uade.tpo.notificador.email.AdapterEmailInterno;

// Puede ser singleton
public class EmailNotificationStrategy implements NotificationStrategy {
  AdapterEmail adapterEmail;

  public EmailNotificationStrategy() {
    adapterEmail = new AdapterEmailInterno();
  }

  @Override
  public void enviar(Mensaje mensaje) {
    adapterEmail.enviar(mensaje.getMensaje(), mensaje.getPersona().getEmail());
  }
}
