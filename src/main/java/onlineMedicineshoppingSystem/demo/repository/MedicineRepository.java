package onlineMedicineshoppingSystem.demo.repository;

import onlineMedicineshoppingSystem.demo.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
