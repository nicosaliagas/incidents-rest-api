package com.my.app.backend;
import java.util.Optional;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.my.app.backend.models.EmployeeEntity;
import com.my.app.backend.repository.EmployeeRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception 
    {       
        Optional<EmployeeEntity> emp = employeeRepository.findById(1L);
 
        logger.info("Employee id 2 -> {}", emp.get());
    }
}
