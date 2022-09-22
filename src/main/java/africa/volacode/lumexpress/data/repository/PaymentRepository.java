package africa.volacode.lumexpress.data.repository;

import africa.volacode.lumexpress.data.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository  extends JpaRepository<Payment, Long> {
}
