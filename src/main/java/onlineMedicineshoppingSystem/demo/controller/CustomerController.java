package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Customer;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Customer")
public class CustomerController {
    @GetMapping("")
    public void getAllCustomer() {
        return;
    }

    @PostMapping("/save")
    public void saveCustomer(@RequestBody Customer customer) {
        return;
    }

    @DeleteMapping("/delete")
    public void deleteById(@PathVariable long id) {
//        deleteCustomerById(id);
        return;
    }
}
