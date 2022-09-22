package africa.volacode.lumexpress.data.repository;

import africa.volacode.lumexpress.data.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
