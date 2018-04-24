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

/**
 * 在Respository 方法中使用，不需要遵循查询方法命名规则
 * 只需要将 @Query定义在Respository中的方法之上即可
 * 命名参数及索引参数的使用
 * 本地查询
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    //Where name like ?% and id < ?
    public List<Employee> findByFirstNameStartingWithAndIdLessThan(String name, Long id);

    @Query("select o from Employee o where o.id=(select max(id) from Employee  t1)")
    public Employee getEmployeeMaxById();

    @Query("select a from Employee a where a.id = :id")
    public Employee findByCustomId(@Param("id")Long id);

    @Query("select o from Employee o where o.firstName=?1 and o.id=?2")
    public List<Employee> queryParams(String name,Long id);

    @Query("select o from Employee o where o.firstName like %?1%")
    public List<Employee> queryParam2(String name);

    @Transactional
    //事务一般添加在Service层上
    @Modifying
    @Query("update Employee a set a.description = :desp where a.id = :id")
    public void updateDesp(@Param("desp")String desp, @Param("id")Long id);

    @Query(value = "SELECT * FROM t_employee WHERE LASTNAME = ?1 ORDER BY ?#{#pageable}",
            countQuery = "SELECT count(*) FROM t_employee WHERE LASTNAME = ?1",
            nativeQuery = true)
    Page<Employee> findByLastname(String lastname, Pageable pageable);

}
