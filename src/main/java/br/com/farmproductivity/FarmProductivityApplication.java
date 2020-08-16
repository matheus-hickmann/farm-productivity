package br.com.farmproductivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FarmProductivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmProductivityApplication.class, args);
	}

}
