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
    NotificationStrategy strategy;
    switch (type) {
      case EMAIL -> strategy = new EmailNotificationStrategy();
      case SMS -> strategy = new SmsNotificationStrategy();
      case WHATSAPP -> strategy = new WhatsappNotificationStrategy();
      default -> throw new RuntimeException("Invalid TipoNotificación "+ type);
    }
    return strategy;
  }
}
