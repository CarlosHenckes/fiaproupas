package br.com.fiap.fiaproupas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.fiap.fiaproupas.entity.Customer;
import br.com.fiap.fiaproupas.moker.CustomerDataMoker;
import br.com.fiap.fiaproupas.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	public void create(Customer customer) {
		customerService.cadastrarCliente(customer);
	}

	@GetMapping(path = "/listallcustomers")
	public List<Customer> listAllCustomers() {
		return customerService.listAllCustomers();
	}

	@GetMapping(path = "/mokecustomer")
	public void MokeCustomer() {
		CustomerDataMoker.populateCustomer(customerService);
	}
}
