package edu.uade.tpo.notificador.email;

// Puede ser singleton
public class AdapterEmailInterno implements AdapterEmail {
  @Override
  public void enviar(String mailBody, String targetEmail) {
    System.out.printf("Sending mail to %s. Body is %s%n", targetEmail, mailBody);
  }
}
