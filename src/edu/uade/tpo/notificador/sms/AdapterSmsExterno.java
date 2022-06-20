package edu.uade.tpo.notificador.sms;

// Puede ser singleton
public class AdapterSmsExterno implements AdapterSms {

  @Override
  public void enviar(String mensaje, String nroTelefono) {
    System.out.printf("Enviando SMS al nro %s con el mensaje %s%n", nroTelefono, mensaje);
  }
}
