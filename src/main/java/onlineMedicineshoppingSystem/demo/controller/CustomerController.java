package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Customer;
import onlineMedicineshoppingSystem.demo.server.CustomerServer;
import onlineMedicineshoppingSystem.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    private CustomerServer customerServer;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> list = customerServer.getAllCustomers();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<?> findCustomerByID(@PathVariable("Id") Long id) {
        Optional<Customer> customer = customerServer.findCustomerById(id);
        if(customer.isPresent()) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        Customer customerIndb = customerServer.findCustomerByCustomerName(userName);
        customerIndb.setUserName(customer.getUserName());
        customerIndb.setPassword(customer.getPassword());
        customerServer.saveNewCustomer(customerIndb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        customerRepository.deleteByCustomerName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
