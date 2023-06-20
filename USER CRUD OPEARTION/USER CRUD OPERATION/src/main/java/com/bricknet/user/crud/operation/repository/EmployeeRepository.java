package com.bricknet.user.crud.operation.repository;

import com.bricknet.user.crud.operation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByName(String name);
}

