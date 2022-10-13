package africa.volacode.lumexpress.service.notifications;

import africa.volacode.lumexpress.data.dtos.request.EmailNotificationRequest;



public interface EmailNotificationService {
    String sendHtmlMail(EmailNotificationRequest emailNotificationRequest);
}
