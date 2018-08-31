package br.com.fiap.fiaproupas.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity @Table(name="Orders")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idorder;
	
	@ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name="idcustomer")
	private Customer customer;
	
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	private List<Item> items = new ArrayList<Item>();
	
	@DateTimeFormat
	private LocalDate orderdate;

	public Order() {
		super();
	}

	public Order(long idorder, Customer customer, List<Item> items, LocalDate orderdate) {
		super();
		this.idorder = idorder;
		this.customer = customer;
		this.items = items;
		this.orderdate = orderdate;
	}

	public long getIdorder() {
		return idorder;
	}

	public void setIdorder(long idorder) {
		this.idorder = idorder;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}	
	
}
