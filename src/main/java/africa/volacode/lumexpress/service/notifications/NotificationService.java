package africa.volacode.lumexpress.service.notifications;

import africa.volacode.lumexpress.data.dtos.request.NotificationRequest;

public interface NotificationService {
    String send(NotificationRequest notificationRequest);
}
