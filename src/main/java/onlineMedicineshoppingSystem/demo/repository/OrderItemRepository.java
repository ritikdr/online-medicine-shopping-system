package onlineMedicineshoppingSystem.demo.repository;

import onlineMedicineshoppingSystem.demo.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}