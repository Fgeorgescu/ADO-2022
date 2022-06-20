package edu.uade.tpo.notificador.strategy;

import edu.uade.tpo.notificador.sms.AdapterSms;
import edu.uade.tpo.notificador.sms.AdapterSmsExterno;

// Puede ser singleton
public class SmsNotificationStrategy implements NotificationStrategy {

  AdapterSms adapterSms;

  public SmsNotificationStrategy() {
    adapterSms = new AdapterSmsExterno();
  }

  @Override
  public void enviar(Mensaje mensaje) {
    // TODO: completar con el nro de telefono de la persona
    adapterSms.enviar(mensaje.getMensaje(), "Nro de telefono");
  }
}
