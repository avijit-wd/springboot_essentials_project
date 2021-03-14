package com.example.demo.customer;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor

public class CustomerService {
	
	private CustomerRepository customerRepository;
	
	Customer getCustomer(Long id) {
		return customerRepository.getOne(id);
	}
	
	List<Customer> getCustomers() {
		return  customerRepository.findAll();
	}
}
