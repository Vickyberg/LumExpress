package africa.volacode.lumexpress.data.repository;

import africa.volacode.lumexpress.data.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository  extends JpaRepository<Store, Long> {
}
