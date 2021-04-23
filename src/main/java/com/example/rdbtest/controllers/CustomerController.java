package com.example.rdbtest.controllers;

import com.example.rdbtest.services.CustomerService;
import com.example.rdbtest.dto.SaveCustomerRequest;
import com.example.rdbtest.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author danushka
 * 4/23/2021
 */
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public Mono<ResponseEntity<List<Customer>>> getCustomers(){
        return this.customerService.getAllCustomers();
    }

    @PostMapping
    public Mono<ResponseEntity<Customer>> saveCustomer(@RequestBody SaveCustomerRequest request){
        return this.customerService.saveCustomer(request);
    }
}
