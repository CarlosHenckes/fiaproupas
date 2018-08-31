package br.com.fiap.fiaproupas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.fiap.fiaproupas.entity.Product;
import br.com.fiap.fiaproupas.moker.ProductDataMoker;
import br.com.fiap.fiaproupas.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(path="/mokeproduct")
	public void insertProduct(Product product) {
		ProductDataMoker.populateProduct(productService);
	}
}
