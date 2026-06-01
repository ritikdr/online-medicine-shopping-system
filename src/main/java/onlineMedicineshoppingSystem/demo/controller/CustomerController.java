package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Customer;
import onlineMedicineshoppingSystem.demo.server.CustomerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    private CustomerServer customerServer;

    @GetMapping("")
    public List<Customer> getAllCustomers() {
        return customerServer.getAllCustomers();
    }

    @GetMapping("/{Id}")
    public Optional<Customer> findCustomerByID(@PathVariable("Id") Long id) {
        return customerServer.findCustomerById(id);
    }

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerServer.saveCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        customerServer.deleteCustomerById(id);
    }
}
