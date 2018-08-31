package br.com.fiap.fiaproupas.moker;

import java.util.Random;


import br.com.fiap.fiaproupas.entity.Customer;
import br.com.fiap.fiaproupas.service.CustomerService;

public class CustomerDataMoker {

	static String[] nomes = { "Carlos", "Maria", "Jose", "Armando", "Luzia", "Wagner", "Marta", "Adriano", "Renata",
			"Julio" };
	static String[] meionomes = { "Mendez", "Souza", "Marinho", "Silva", "Jardim", "Vanini", "Campos", "Sales",
			"Kremmer", "Hubrecht" };
	static String[] sobrenomes = { "Pinto", "Santos", "Lustosa", "Rodrigues", "Finn", "Martin", "Henckes", "Cristensen",
			"Rebel", "Rabelo" };

	public static void populateCustomer(CustomerService customerService) {

		try {

			for (int i = 0; i < 1000; i++) {
				Customer customer = new Customer();
				customer.setName(nomes[ran(9)] + " " + meionomes[ran(9)] + " " + sobrenomes[ran(9)]);
				customer.setCnpj_cpf(cpf());
				
				customerService.cadastrarCliente(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String cpf() {
		Random rand = new Random();
		long value = rand.nextInt()+10000000000L;
		return String.valueOf(value);
	}

	private static int ran(int p) {
		Random rand = new Random();
		int value = rand.nextInt(p);
		return value;
	}
}
