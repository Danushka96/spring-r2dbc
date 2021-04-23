package com.example.rdbtest.repositories;

import com.example.rdbtest.entities.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author danushka
 * 4/23/2021
 */
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
    Flux<Customer> findByLastName(String lastName);
}
