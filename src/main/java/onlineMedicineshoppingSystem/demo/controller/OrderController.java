package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @GetMapping("")
    public void getAllOrder() {
        return;
    }

    @GetMapping("/{id}")
    public void getOrderByID(@PathVariable("id") Long id) {
        return;
    }

    @PostMapping("/save")
    public void saveOrder(@RequestBody Order order) {
        return;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        return;
    }
}
