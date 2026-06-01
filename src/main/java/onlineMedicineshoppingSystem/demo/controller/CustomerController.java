package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Customer;
import onlineMedicineshoppingSystem.demo.server.CustomerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    private CustomerServer customerServer;

    @GetMapping("")
    public List<Customer> getAllCustomers() {
        return customerServer.getAllCustomers();
    }

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerServer.saveCustomer(customer);
    }

    @DeleteMapping("/delete")
    public void deleteById(@PathVariable long id) {
//        deleteCustomerById(id);
        return;
    }
}
