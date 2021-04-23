package com.example.rdbtest.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author danushka
 * 4/23/2021
 */
@Data
public class Customer {
    @Id
    private Long id;

    private final String firstName;

    private final String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
