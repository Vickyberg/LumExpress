package africa.volacode.lumexpress.service.notifications;

import africa.volacode.lumexpress.data.dtos.request.NotificationRequest;

public interface LumExpressNotificationService {
    String send(NotificationRequest notificationRequest);
}
