package br.com.fiap.fiaproupas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long iditem;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idorder")
	private Order order;
	
	@ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name="idproduct")
	private Product product;
	
	private double price;
	
	private int qty;

	public Item() {
		super();
	}

	public Item(long iditem, Order order, Product product, double price, int qty) {
		super();
		this.iditem = iditem;
		this.order = order;
		this.product = product;
		this.price = price;
		this.qty = qty;
	}

	public long getIditem() {
		return iditem;
	}

	public void setIditem(long iditem) {
		this.iditem = iditem;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
