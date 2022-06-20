package edu.uade.tpo.notificador.email;

// Puede ser singleton
public class AdapterEmailInterno implements AdapterEmail {
  @Override
  public void enviar(String mailBody, String targetEmail) {
    System.out.printf("Se envia el email a  %s. Cuerpo es %s%n", targetEmail, mailBody);
  }
}
