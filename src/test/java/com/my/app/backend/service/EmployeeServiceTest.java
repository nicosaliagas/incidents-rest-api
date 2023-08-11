package com.my.app.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        assertEquals(3, employeeService.list().size());
    }
}
