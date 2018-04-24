package com.tn.jpa.test;

import com.tn.jpa.domain.Employee;
import com.tn.jpa.repository.EmployeeRepository;
import com.tn.jpa.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JpaTest {
    @Test
    public void springTest(){
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-demo-cfg.xml");
        UserService userService = (UserService)ctx.getBean("userService", UserService.class);
        userService.createNewAccount("ZhangJianPing", "123456", 1);
    }
    @Test
    public void repositoryTest(){
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-demo-cfg.xml");
        EmployeeRepository er = ctx.getBean("EmployeeRepository", EmployeeRepository.class);
        Employee employee = new Employee();
        employee.setFirstName("smith");
        employee.setLastName("zhang");
        er.save(employee);
    }
}
