package africa.volacode.lumexpress.data.repository;

import africa.volacode.lumexpress.data.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
