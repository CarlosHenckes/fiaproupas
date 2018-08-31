package br.com.fiap.fiaproupas.utils;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.fiap.fiaproupas.entity.Order;
import br.com.fiap.fiaproupas.jms.JmsProducer;

public class ProcessInvoiceThread extends Thread {

	private List<Order> orders;
	
	final static Logger logger = Logger.getLogger(JmsProducer.class);
	
	public ProcessInvoiceThread(List<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public void run() {
		logger.info("Starting producing block of invoices (" + orders.size() + " in total)...");
		orders.forEach(item->{
			InvoiceMaker.generate(item);
		});
	}
}
