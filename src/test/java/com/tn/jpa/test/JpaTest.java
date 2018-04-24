package com.tn.jpa.test;

import com.tn.jpa.domain.Employee;
import com.tn.jpa.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

@ContextConfiguration(locations = { "classpath:spring-demo-cfg.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void employTest(){
        Employee employee = new Employee();
        employee.setFirstName("smint6");
        employee.setLastName("weil6");
        employeeRepository.save(employee);
    }

    @Test
    public void employUpdate(){
        employeeRepository.updateDesp("nihao",1L);
    }

    @Test
    public void employPage(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(1, 2, sort);
        Page<Employee> pe = employeeRepository.findAll(pageable);
        System.out.println("total pages:" + pe.getTotalPages());
        System.out.println("total elements:" + pe.getTotalElements());
        List<Employee> le = pe.getContent();
        for(Employee employee: le){
            System.out.println(employee.toString());
        }
    }

    @Test
    public void employcustompage(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(0, 2, sort);
        Page<Employee> pe = employeeRepository.findByLastname("weil2",pageable);
        System.out.println("total pages:" + pe.getTotalPages());
        System.out.println("total elements:" + pe.getTotalElements());
        List<Employee> le = pe.getContent();
        for(Employee employee: le){
            System.out.println(employee.toString());
        }
    }

}
