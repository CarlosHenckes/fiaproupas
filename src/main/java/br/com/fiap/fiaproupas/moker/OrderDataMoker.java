package br.com.fiap.fiaproupas.moker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import br.com.fiap.fiaproupas.entity.Customer;
import br.com.fiap.fiaproupas.entity.Item;
import br.com.fiap.fiaproupas.entity.Order;
import br.com.fiap.fiaproupas.entity.Product;
import br.com.fiap.fiaproupas.service.CustomerService;
import br.com.fiap.fiaproupas.service.OrderService;
import br.com.fiap.fiaproupas.service.ProductService;

public class OrderDataMoker {

	public static void populateOrder(OrderService orderService, CustomerService customerService,
			ProductService productService) {

		try {
			List<Customer> customers = customerService.listAllCustomers();

			for (Customer customer : customers) {
				Order order = new Order();
				order.setOrderdate(diadacompra());
				order.setCustomer(customer);

				List<Item> items = new ArrayList<Item>();
				int qtyItems = ran(4);

				for (int i = 0; i < qtyItems; i++) {
					Product product = new Product();
					product = productService.findByProductId(ran(1000));
					
					items.add(new Item(0L, order, product, product.getPrice(), ran(3)));
				}
				order.setItems(items);

				orderService.newOrder(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int ran(int limit) {
		Random rand = new Random();
		int value = rand.nextInt(limit) + 1;
		return value;
	}

	private static LocalDate diadacompra() {
		long minDay = LocalDate.of(2018, 1, 1).toEpochDay();
		long maxDay = LocalDate.of(2018, 6, 12).toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
		LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		return randomDate;
	}
}
