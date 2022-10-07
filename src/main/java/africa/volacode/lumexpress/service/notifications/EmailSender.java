package africa.volacode.lumexpress.service.notifications;

public interface EmailSender {
    String sendHtmlMail(EmailDetails emailDetails);
}
