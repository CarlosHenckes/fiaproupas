package br.com.fiap.fiaproupas.jms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
 
@Component
public class JmsProducer {
	final static Logger logger = Logger.getLogger(JmsProducer.class);
	static List<String> fila = new ArrayList<>(Arrays.asList("fila1", "fila2", "fila3", "fila4", "fila5"));
	static int ponteiro = 0;
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jsa.activemq.queue}")
	String queue;
	
	public void send(String msg){
		logger.info("fabricar: " + msg);
		int i = getPonteiro();
		jmsTemplate.convertAndSend(fila.get(i), msg);
	}
	
	static int getPonteiro() {
		int val = 0;
		if (5 == ponteiro) {
			val = 0;
			ponteiro = -1;
		} else {
			val = ponteiro;
		}
		ponteiro++;
		return val;
	}
}