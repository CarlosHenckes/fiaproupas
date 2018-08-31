package br.com.fiap.fiaproupas.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fiaproupas.entity.Product;
import br.com.fiap.fiaproupas.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	EntityManager em;

	public List<Product> listAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	public void newProduct(Product product) {
		productRepository.save(product);
	}

	public Product findByProductId(long id) {
		return em.find(Product.class, id);
	}
}
