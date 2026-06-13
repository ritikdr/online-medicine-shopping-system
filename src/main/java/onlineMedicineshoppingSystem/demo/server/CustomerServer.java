package onlineMedicineshoppingSystem.demo.server;

import onlineMedicineshoppingSystem.demo.entity.Customer;
import onlineMedicineshoppingSystem.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServer {

    @Autowired
    private CustomerRepository customerRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer findCustomerByCustomerName(String userName) {
        return customerRepository.findCustomerByCustomerName(userName);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void saveNewCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
    }

    public void deleteCustomerById(long id) {
        customerRepository.deleteById(id);
    }
}
