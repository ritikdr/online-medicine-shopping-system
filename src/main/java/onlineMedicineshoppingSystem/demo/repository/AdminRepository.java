package onlineMedicineshoppingSystem.demo.repository;

import onlineMedicineshoppingSystem.demo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
