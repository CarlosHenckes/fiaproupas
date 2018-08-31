package br.com.fiap.fiaproupas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fiaproupas.entity.Customer;
import br.com.fiap.fiaproupas.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public void cadastrarCliente(Customer customer) {
		customerRepository.save(customer);
	}
	
	public List<Customer> listAllCustomers(){
		return (List<Customer>) customerRepository.findAll();
	}
}
