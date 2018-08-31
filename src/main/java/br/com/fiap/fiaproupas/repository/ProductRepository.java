package br.com.fiap.fiaproupas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fiaproupas.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	Product findByIdproduct(long id);
}
