package onlineMedicineshoppingSystem.demo.server;

import onlineMedicineshoppingSystem.demo.entity.Customer;
import onlineMedicineshoppingSystem.demo.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CustomerDetailServerImp implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUserName(userName);

        System.out.println("Login Username = " + userName);
        System.out.println("Customer = " + customer);
        if(customer != null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(customer.getUserName())
                    .password(customer.getPassword())
                    .roles("CUSTOMER")
                            .build();
        }
        throw new UsernameNotFoundException("User not found username: "+ userName);
    }
}


