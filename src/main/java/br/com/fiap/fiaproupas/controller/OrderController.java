package br.com.fiap.fiaproupas.controller;

import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.fiap.fiaproupas.entity.Order;
import br.com.fiap.fiaproupas.jms.JmsProducer;
import br.com.fiap.fiaproupas.moker.OrderDataMoker;
import br.com.fiap.fiaproupas.service.CustomerService;
import br.com.fiap.fiaproupas.service.OrderService;
import br.com.fiap.fiaproupas.service.ProductService;

@Controller
public final class OrderController {	

	public OrderController() {
		super();
	}

	@Autowired
	OrderService orderService;

	@Autowired
	CustomerService customerService;

	@Autowired
	ProductService productService;
	
	@Autowired
	JmsProducer jmsProducer;

	@GetMapping(path = "/mokeorder")
	public void createOrder(Order order) {
		OrderDataMoker.populateOrder(orderService, customerService, productService);
	}
	
	public Order findOrderById(long id) throws Exception {
		return orderService.findOrderById(id);
	}
	
	public List<Order> listOrdersByMonthAndYear(YearMonth yearMonth){
		return orderService.ordensByMonthAndYear(yearMonth);
	}

	@RequestMapping(path = "/ticket/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(code=HttpStatus.OK)
	public boolean generateInvoice(@PathVariable("id") long id) {
		jmsProducer.send(String.valueOf(id));
		return true;
	}

}
