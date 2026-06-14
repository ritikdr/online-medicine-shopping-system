package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Order;
import onlineMedicineshoppingSystem.demo.server.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private OrderServer orderServer;

    @GetMapping("")
    public ResponseEntity<List<Order>> getAllOrder() {
        List<Order> list = orderServer.getAllOrder();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderByID(@PathVariable("id") Long id) {
        Optional<Order> order = orderServer.findOrderById(id);
        if(order.isPresent()) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        Order saveOrder = orderServer.saveOrder(order);
        return ResponseEntity.ok(saveOrder);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        orderServer.deleteOrderById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("customer/{customerId}")
    public ResponseEntity<List<Order>> getOrderByCustomerId(@PathVariable Long customerId) {
        List<Order> list = orderServer.getOrderByCustomerId(customerId);
        return ResponseEntity.ok(list);
    }
}
