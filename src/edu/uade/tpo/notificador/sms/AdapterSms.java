package edu.uade.tpo.notificador.sms;

public interface AdapterSms {
  void enviar(String mensaje, String nroTelefono);
}
