package br.com.fiap.fiaproupas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@EnableCaching
@SpringBootApplication
@EnableJpaRepositories
public class FiaproupasApplication {

	public static void main(String[] args) {		
		
		SpringApplication.run(FiaproupasApplication.class, args);

	}
}
