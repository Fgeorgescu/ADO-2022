package edu.uade.tpo.notificador.whatsapp;

// Puede ser singleton
public class AdapterWhatsAppExterno implements AdapterWhatsapp{

  public AdapterWhatsAppExterno() {
  }

  public void enviar(WhatsappMessageDTO notification) {
    System.out.println(String.format("Enviar notificaci\u00f3n %s a usuario %s via libreria externa de whatsapp",
        notification.getMessage(),
        notification.getTargetUser()));
  }
}
