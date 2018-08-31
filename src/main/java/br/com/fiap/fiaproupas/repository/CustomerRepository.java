package br.com.fiap.fiaproupas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fiaproupas.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
}
