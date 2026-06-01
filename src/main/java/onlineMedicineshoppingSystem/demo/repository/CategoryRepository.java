package onlineMedicineshoppingSystem.demo.repository;

import onlineMedicineshoppingSystem.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
