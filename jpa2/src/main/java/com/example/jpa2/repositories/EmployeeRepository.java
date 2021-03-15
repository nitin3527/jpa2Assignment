package com.example.jpa2.repositories;

import com.example.jpa2.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Query("select firstName, lastName from Employee where " +
            "salary > (select AVG(salary) from Employee)" +
            " ORDER BY age ASC, salary DESC")
    List<Object[]> finadAllEmployee();

    @Query("select avg(salary) from Employee")
    double findAvgSalary();

    @Modifying //Q2 JPQL
    @Transactional
    @Query("update Employee set salary=:salary where salary< :findAvgSalary")
    void updateSalaryOfEmployeeLessThanAvg(@Param("salary") double salary, @Param("findAvgSalary") double findAvgSalary);

    @Query("select min(salary) from Employee")
    double findMinSalary();


    @Modifying// Q3 JPQL
    @Query("delete from Employee where salary = :findMinSalary")
    void deleteEmployeeSalary(@Param("findMinSalary") double findMinSalary);

    @Query(value = "select empid,empfirstname from employee where " +
            "emplastname like '%singh'", nativeQuery = true)
    List<Object[]> getAllEmployeeWhoesNameEndsWith();

    @Modifying
    @Query(value = "delete from employee where empage>:age", nativeQuery = true)
    void deleteEmployeeHaingAgeGreaterThan(@Param("age") int age);
}

