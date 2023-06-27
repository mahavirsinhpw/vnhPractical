package com.vnhPractical.crudOperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnhPractical.crudOperation.entity.Customer;
import com.vnhPractical.crudOperation.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> saveCustomers(List<Customer> customers) {
		return customerRepository.saveAll(customers);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).orElse(null);
	}

	public Customer getCustomerByName(String name) {
		return customerRepository.findByName(name);
	}

	public String deleteCustomer(int id) {
		customerRepository.deleteById(id);
		return "Customer removed  " + id;
	}

	public Customer updateCustomer(Customer customer) {
		Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
		existingCustomer.setName(customer.getName());
		;
		existingCustomer.setDetails(customer.getDetails());
		existingCustomer.setAccountType(customer.getAccountType());
		existingCustomer.setBusinessRequirements(customer.getBusinessRequirements());
		existingCustomer.setContractType(customer.getContractType());
		return customerRepository.save(existingCustomer);
	}

}
