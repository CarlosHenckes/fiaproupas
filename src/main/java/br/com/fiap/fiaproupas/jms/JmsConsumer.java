package br.com.fiap.fiaproupas.jms;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import br.com.fiap.fiaproupas.controller.OrderController;
import br.com.fiap.fiaproupas.entity.Order;
import br.com.fiap.fiaproupas.utils.InvoiceMaker;
import br.com.fiap.fiaproupas.utils.ProcessInvoiceThread;

@Component
public class JmsConsumer {

	@Autowired
	OrderController orderController;

	final static Logger logger = Logger.getLogger(JmsProducer.class);

	private List<Order> orders = new ArrayList<Order>();

	private static final Integer BLOCK_CHUNK = 25;

	@PostConstruct
	private void init() {

		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

		scheduler.scheduleAtFixedRate(() -> {

			if (orders.size() > 0) {

				new Thread(new Runnable() {

					@Override
					public void run() {
						//logger.info("ordens no momento: " + orders.size());
						
						List<Order> ord = new ArrayList<Order>(orders);
						
						orders.removeAll(orders);
						
						ord.forEach(item -> {
							InvoiceMaker.generate(item);
						});
						
						//logger.info("produzindo ... (" + ord.size() + " notas)");
					}

				}).start();
			}

		}, 1000, 1000, TimeUnit.MILLISECONDS);

	}

	private void makeOne(Long orderId) {
		try {

			Order order = orderController.findOrderById(orderId);
			orders.add(order);

		} catch (Exception e) {

			logger.error("ERROR: " + e.getMessage());

		}
	}

	private void makeMonth(int year, int month) {

		YearMonth yearMonth = YearMonth.of(year, month);
		List<Order> monthOrders = orderController.listOrdersByMonthAndYear(yearMonth);
		List<List<Order>> chunks = Lists.partition(monthOrders, BLOCK_CHUNK);

		chunks.forEach(chunk -> {
			new ProcessInvoiceThread(chunk).start();
		});
	}

	private void execute(String msg) throws Exception {
		try {
			long orderId = Long.parseLong(msg);

			if (orderId == -1) { // list all from february
				makeMonth(2018, 2);

			} else if (orderId > 0) {
				makeOne(orderId);
			}
		} catch (NumberFormatException nfe) {
			throw new Exception("O número de pedido é inválido.");
		}
	}

	@JmsListener(destination = "fila1", containerFactory = "jsaFactory")
	private void receive(String msg) throws Exception {
		execute(msg);
		Thread.sleep(10);
	}

	@JmsListener(destination = "fila2", containerFactory = "jsaFactory")
	private void receive2(String msg) throws Exception {
		execute(msg);
		Thread.sleep(10);
	}

	@JmsListener(destination = "fila3", containerFactory = "jsaFactory")
	private void receive3(String msg) throws Exception {
		execute(msg);
		Thread.sleep(10);
	}

	@JmsListener(destination = "fila4", containerFactory = "jsaFactory")
	private void receive4(String msg) throws Exception {
		execute(msg);
		Thread.sleep(10);
	}

	@JmsListener(destination = "fila5", containerFactory = "jsaFactory")
	private void receive5(String msg) throws Exception {
		execute(msg);
		Thread.sleep(10);
	}

}
