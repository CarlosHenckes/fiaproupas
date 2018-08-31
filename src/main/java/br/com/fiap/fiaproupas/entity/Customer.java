package br.com.fiap.fiaproupas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idcustomer;
	
	private String name;
	
	private String cnpj_cpf;	
	
	public Customer() {
		super();
	}

	public Customer(long idcustomer, String name, String cnpj_cpf) {
		super();
		this.idcustomer = idcustomer;
		this.name = name;
		this.cnpj_cpf = cnpj_cpf;
	}

	public long getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(long idcustomer) {
		this.idcustomer = idcustomer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj_cpf() {
		return cnpj_cpf;
	}

	public void setCnpj_cpf(String cnpj_cpf) {
		this.cnpj_cpf = cnpj_cpf;
	}	
}
