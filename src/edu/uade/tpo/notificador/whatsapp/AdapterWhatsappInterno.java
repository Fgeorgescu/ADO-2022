package edu.uade.tpo.notificador.whatsapp;

// Puede ser singleton
public class AdapterWhatsappInterno implements AdapterWhatsapp {

  @Override
  public void enviar(WhatsappMessageDTO whatsappMessage) {
    System.out.println(String.format("Internally implemented whatsapp notification service. Username is %s "
        + "and message is: %s", whatsappMessage.getTargetUser(), whatsappMessage.getMessage()));
  }
}
