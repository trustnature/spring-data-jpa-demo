package com.tn.jpa.repository;

import com.tn.jpa.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);
}
