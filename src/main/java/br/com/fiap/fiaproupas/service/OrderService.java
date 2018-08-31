package br.com.fiap.fiaproupas.service;

import java.time.YearMonth;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.fiap.fiaproupas.entity.Order;
import br.com.fiap.fiaproupas.exception.OrderNotFoundException;
import br.com.fiap.fiaproupas.jms.JmsProducer;
import br.com.fiap.fiaproupas.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	EntityManager em;

	final static Logger logger = Logger.getLogger(JmsProducer.class);

	public void newOrder(Order order) {
		orderRepository.save(order);
	}

	@Cacheable(value = "orderFindCache")
	public Order findOrderById(long id) throws Exception {
		Order order = em.find(Order.class, id);
		logger.info("-- retriving data from db.");
		if (order == null)
			throw new OrderNotFoundException("this order does not exist.");
		return order;
	}

	public List<Order> ordensByMonthAndYear(YearMonth yearMonth) {
		try {
			TypedQuery<Order> query = em.createQuery(
					"select d from Order d where Year(d.orderdate) = :year and Month(d.orderdate) = :month",
					Order.class);
			query.setParameter("year", yearMonth.getYear());
			query.setParameter("month", yearMonth.getMonthValue());
			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
