package com.example.rdbtest.services;

import com.example.rdbtest.dto.SaveCustomerRequest;
import com.example.rdbtest.entities.Customer;
import com.example.rdbtest.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author danushka
 * 4/23/2021
 */
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Mono<ResponseEntity<List<Customer>>> getAllCustomers() {
        return this.customerRepository.findAll().collectList()
                .map(ResponseEntity::ok);
    }

    public Mono<ResponseEntity<Customer>> saveCustomer(SaveCustomerRequest request) {
        return this.customerRepository.save(new Customer(
                request.getFirstName(),
                request.getLastName())
        ).map(ResponseEntity::ok);
    }
}
