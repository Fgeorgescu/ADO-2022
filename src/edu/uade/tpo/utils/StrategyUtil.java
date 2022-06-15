package edu.uade.tpo.utils;

import edu.uade.tpo.notificador.strategy.EmailNotificationStrategy;
import edu.uade.tpo.notificador.strategy.NotificationStrategy;
import edu.uade.tpo.notificador.strategy.SmsNotificationStrategy;
import edu.uade.tpo.notificador.strategy.WhatsappNotificationStrategy;
import edu.uade.tpo.personas.notificacion.TipoNotificacion;

// Clase para mappear las estrategias con sus denominadores.
//N Se podría reemplazar por un patron o algún otro componente
public class StrategyUtil {
  public static NotificationStrategy getNotificationStrategy(TipoNotificacion type) {
    switch (type) {
      case EMAIL -> new EmailNotificationStrategy();
      case SMS -> new SmsNotificationStrategy();
      case WHATSAPP -> new WhatsappNotificationStrategy();
    }
    throw new RuntimeException("Invalid TipoNotificación "+ type);
  }
}
