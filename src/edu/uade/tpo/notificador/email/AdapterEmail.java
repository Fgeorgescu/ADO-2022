package edu.uade.tpo.notificador.email;

public interface AdapterEmail {

  void enviar(String mailBody, String targetEmail);
}
