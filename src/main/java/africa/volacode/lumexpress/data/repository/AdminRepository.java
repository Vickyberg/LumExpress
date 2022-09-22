package africa.volacode.lumexpress.data.repository;

import africa.volacode.lumexpress.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Long> {
}
