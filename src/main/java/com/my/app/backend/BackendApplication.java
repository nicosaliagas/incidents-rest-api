package com.my.app.backend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.my.app.backend.bootstrap.DataInitializer;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.my.app.backend.models"})  // force scan JPA entities
public class BackendApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final DataInitializer dataInitializer;

	public BackendApplication(DataInitializer dataInitializer) {
		this.dataInitializer = dataInitializer;
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception 
    {       
		dataInitializer.initializeData();

        logger.info("Hello API!");
    }
}
