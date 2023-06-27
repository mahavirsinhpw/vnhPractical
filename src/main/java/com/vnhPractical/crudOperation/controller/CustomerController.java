package com.vnhPractical.crudOperation.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vnhPractical.crudOperation.entity.Customer;
import com.vnhPractical.crudOperation.response.CommonResponse;
import com.vnhPractical.crudOperation.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping("/addCustomer")
	public ResponseEntity<CommonResponse> addCustomer(@Valid @RequestBody Customer customer) {
		CommonResponse commonResponse = new CommonResponse();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");

		LocalDate date2 = LocalDate.parse("2002-01-01", dtf);

		// date Check
		if (customer.getDetails().getDob().isAfter(date2)) {

			commonResponse.setResponseMessage("Please provide valid date! date Should be less than 01/01/2002");
			commonResponse.setStatus(HttpStatus.NOT_ACCEPTABLE);
			return new ResponseEntity<CommonResponse>(commonResponse, commonResponse.getStatus());
		}
		if ((!customer.getDetails().getSex().equals("M")) && (!customer.getDetails().getSex().equals("F"))) {
			commonResponse.setResponseMessage("Sex should be M or F ");
			commonResponse.setStatus(HttpStatus.NOT_ACCEPTABLE);
			return new ResponseEntity<CommonResponse>(commonResponse, commonResponse.getStatus());
		}
		if ((!customer.getContractType().equals("fulltime")) && (!customer.getContractType().equals("parttime"))) {
			commonResponse.setResponseMessage("contractType should be fulltime or parttime");
			commonResponse.setStatus(HttpStatus.NOT_ACCEPTABLE);
			return new ResponseEntity<CommonResponse>(commonResponse, commonResponse.getStatus());
		}

		service.saveCustomer(customer);
		commonResponse.setStatus(HttpStatus.OK);
		commonResponse.setResponseMessage("Customer saved successfully!");

		return new ResponseEntity<CommonResponse>(commonResponse, commonResponse.getStatus());

	}

	@PostMapping("/addCustomers")
	public List<Customer> addCustomers(@RequestBody List<Customer> Customers) {
		return service.saveCustomers(Customers);
	}

	@GetMapping("/getAll")
	public List<Customer> findAll() {
		return service.getAllCustomers();
	}

	@GetMapping("/getCustomerById/{id}")
	public Customer findCustomerById(@PathVariable int id) {
		return service.getCustomerById(id);
	}

	@GetMapping("/getCustomerByName/{name}")
	public Customer findCustomerByName(@PathVariable String name) {
		return service.getCustomerByName(name);
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteCustomer(@PathVariable int id) {
		return service.deleteCustomer(id);
	}

	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}

}
