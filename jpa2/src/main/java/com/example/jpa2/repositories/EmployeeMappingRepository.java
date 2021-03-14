package com.example.jpa2.repositories;

import com.example.jpa2.entity.EmployeeMapping;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeMappingRepository extends CrudRepository<EmployeeMapping, Integer> {
}
