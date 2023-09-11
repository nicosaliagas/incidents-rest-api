package com.my.app.backend;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({"/employees_schema.sql", "/import_employees.sql"})
class BackendApplicationTest {
	/*@Autowired
    private EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
    public void testLoadDataForTestClass() {
        assertEquals(3, employeeRepository.findAll().size());
    }*/
}
