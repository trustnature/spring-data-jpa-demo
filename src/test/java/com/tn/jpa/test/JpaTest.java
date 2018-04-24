package com.tn.jpa.test;

import com.tn.jpa.domain.Employee;
import com.tn.jpa.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:spring-demo-cfg.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void employTest(){
        Employee employee = new Employee();
        employee.setFirstName("smint");
        employee.setLastName("weil");
        employeeRepository.save(employee);
    }

}
