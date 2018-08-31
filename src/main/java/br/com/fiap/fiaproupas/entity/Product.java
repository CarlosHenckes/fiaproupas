package br.com.fiap.fiaproupas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idproduct;
	
	private String description;
	
	private double price;

	public Product() {
		super();
	}

	public Product(long idproduct, String description, double price) {
		super();
		this.idproduct = idproduct;
		this.description = description;
		this.price = price;
	}

	public long getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(long idproduct) {
		this.idproduct = idproduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
