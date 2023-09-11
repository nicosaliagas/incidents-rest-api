package com.my.app.backend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.my.app.backend.models"})  // force scan JPA entities
public class BackendApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception 
    {       
        logger.info("Hello API!");
    }
}
