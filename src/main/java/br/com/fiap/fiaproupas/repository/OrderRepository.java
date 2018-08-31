package br.com.fiap.fiaproupas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fiaproupas.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
	Order findByIdorder(long id);
}
