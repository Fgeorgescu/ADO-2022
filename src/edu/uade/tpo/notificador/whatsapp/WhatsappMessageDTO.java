package edu.uade.tpo.notificador.whatsapp;

public class WhatsappMessageDTO {
  private String message;
  private String targetUser;

  public WhatsappMessageDTO(String message, String targetUser) {
    this.message = message;
    this.targetUser = targetUser;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getTargetUser() {
    return targetUser;
  }

  public void setTargetUser(String targetUser) {
    this.targetUser = targetUser;
  }
}
