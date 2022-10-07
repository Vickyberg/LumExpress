package africa.volacode.lumexpress.data.repository;

import africa.volacode.lumexpress.data.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
