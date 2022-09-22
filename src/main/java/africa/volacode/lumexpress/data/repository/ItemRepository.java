package africa.volacode.lumexpress.data.repository;

import africa.volacode.lumexpress.data.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
