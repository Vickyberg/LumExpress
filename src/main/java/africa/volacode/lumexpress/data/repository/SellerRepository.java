package africa.volacode.lumexpress.data.repository;

import africa.volacode.lumexpress.data.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
