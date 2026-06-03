package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.OrderItem;
import onlineMedicineshoppingSystem.demo.server.OrderItemServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OrderItem")
public class OrderItemController {

    @Autowired
    private OrderItemServer orderItemServer;

    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemServer.getAllOrderItems();
    }

    @GetMapping("/{id}")
    public Optional<OrderItem> getOrderItemById(@PathVariable Long id) {
        return orderItemServer.getOrderItemById(id);
    }

    @PostMapping("/save")
    public OrderItem saveOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemServer.saveOrderItem(orderItem);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemServer.deleteOrderItem(id);
    }
}