package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Order;
import onlineMedicineshoppingSystem.demo.server.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private OrderServer orderServer;

    @GetMapping("")
    public List<Order> getAllOrder() {
        return orderServer.getAllOrder();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderByID(@PathVariable("id") Long id) {
        return orderServer.findOrderById(id);
    }

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order) {
        return orderServer.saveOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        orderServer.deleteOrderById(id);
    }
}
