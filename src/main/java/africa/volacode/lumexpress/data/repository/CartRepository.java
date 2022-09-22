package africa.volacode.lumexpress.data.repository;

import africa.volacode.lumexpress.data.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
