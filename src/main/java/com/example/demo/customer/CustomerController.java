package com.example.demo.customer;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exp.ApiRequestException;
import com.example.demo.exp.NotFoundException;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping(path = "api/v1/customers")
@AllArgsConstructor
public class CustomerController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class); 
	
	private CustomerService customerService;
	
	@GetMapping
	List<Customer> getCustomers() {
		LOGGER.info("Get customers was called");
		return customerService.getCustomers();
	}
	
	@GetMapping(path = "{customerId}")
	Customer getCustomer(@PathVariable("customerId") Long id) {
		return customerService.getCustomer(id);
				
	}
	
	@GetMapping(path = "{customerId}/exception")
	Customer getCustomerException(@PathVariable("customerId") Long id) {
		throw new ApiRequestException(
				"ApiRequestException "+ id
				);
			}
	
	@PostMapping
	void createNewCustomer(@Valid @RequestBody Customer customer) {
		System.out.println("Post Request");
		System.out.println(customer);
	}
	
	@PutMapping
	void updateCustomer(@RequestBody Customer customer) {
		System.out.println("Update Request");
		System.out.println(customer);
	}
	
	@DeleteMapping(path = "{customerId}")
	void deleteCustomer(@PathVariable("customerId") Long id) {
		System.out.println("Delete request for customer with id " +id);
	}
}
