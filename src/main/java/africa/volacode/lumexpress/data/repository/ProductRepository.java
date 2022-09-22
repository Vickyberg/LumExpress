package africa.volacode.lumexpress.data.repository;

import africa.volacode.lumexpress.data.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
