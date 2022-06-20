package edu.uade.tpo.notificador.whatsapp;

// Puede ser singleton
public class AdapterWhatsAppExterno implements AdapterWhatsapp{

  public AdapterWhatsAppExterno() {
  }

  public void enviar(WhatsappMessageDTO notification) {
    System.out.println(String.format("Sending notification %s to user %s via external whatsapp library",
        notification.getMessage(),
        notification.getTargetUser()));
  }
}
