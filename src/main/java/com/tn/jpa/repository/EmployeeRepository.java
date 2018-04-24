package com.tn.jpa.repository;

import com.tn.jpa.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    @Query("select a from Employee a where a.id = :id")
    public Employee findByCustomId(@Param("id")Long id);

    @Transactional
    @Modifying
    @Query("update Employee a set a.description = :desp where a.id = :id")
    public void updateDesp(@Param("desp")String desp, @Param("id")Long id);

    @Query(value = "SELECT * FROM t_employee WHERE LASTNAME = ?1 ORDER BY ?#{#pageable}",
            countQuery = "SELECT count(*) FROM t_employee WHERE LASTNAME = ?1",
            nativeQuery = true)
    Page<Employee> findByLastname(String lastname, Pageable pageable);

}
