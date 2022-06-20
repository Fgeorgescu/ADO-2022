package edu.uade.tpo.notificador.strategy;

import edu.uade.tpo.notificador.whatsapp.AdapterWhatsAppExterno;
import edu.uade.tpo.notificador.whatsapp.AdapterWhatsapp;
import edu.uade.tpo.notificador.whatsapp.WhatsappMessageDTO;

// Puede ser singleton
public class WhatsappNotificationStrategy implements NotificationStrategy {
  private final AdapterWhatsapp adapterWhatsapp;

  public WhatsappNotificationStrategy() {
    this.adapterWhatsapp = new AdapterWhatsAppExterno();
  }

  @Override
  public void enviar(Mensaje mensaje) {
    // TODO: Terminar el tema del target user
    WhatsappMessageDTO whatsappMessage = new WhatsappMessageDTO(mensaje.getMensaje(), "");

    adapterWhatsapp.enviar(whatsappMessage);
  }
}
