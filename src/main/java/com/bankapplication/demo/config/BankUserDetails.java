package com.bankapplication.demo.config;

import com.bankapplication.demo.model.Customer;
import com.bankapplication.demo.repository.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
// we use custom authentication provider now
public class BankUserDetails implements UserDetailsService {

    private final CustomerRepository customerRepository;

    public BankUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String userName, password = null;
        List<GrantedAuthority> authorities = null;
        List<Customer> customers = customerRepository.findByEmail(username);
        if (customers.size() == 0) {
            throw new UsernameNotFoundException("User details not found for user: " + username);
        } else {
            userName = customers.get(0).getEmail();
            password = customers.get(0).getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
        }

        return new User(username, password, authorities);
    }
}
