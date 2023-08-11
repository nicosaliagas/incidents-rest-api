package com.my.app.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.my.app.backend.repository.EmployeeRepository;

@SpringBootTest
@Sql({"/employees_schema.sql", "/import_employees.sql"})
class BackendApplicationTest {
	@Autowired
    private EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
    public void testLoadDataForTestClass() {
        assertEquals(3, employeeRepository.findAll().size());
    }
}
