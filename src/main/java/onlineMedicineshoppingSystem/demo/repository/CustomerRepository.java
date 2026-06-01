package onlineMedicineshoppingSystem.demo.repository;

import onlineMedicineshoppingSystem.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
