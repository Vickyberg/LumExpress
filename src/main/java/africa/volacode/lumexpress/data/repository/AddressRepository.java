package africa.volacode.lumexpress.data.repository;

import africa.volacode.lumexpress.data.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
