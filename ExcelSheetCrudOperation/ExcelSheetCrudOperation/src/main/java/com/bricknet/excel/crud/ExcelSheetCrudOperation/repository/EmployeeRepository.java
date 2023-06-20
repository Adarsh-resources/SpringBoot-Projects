package com.bricknet.excel.crud.ExcelSheetCrudOperation.repository;

import com.bricknet.excel.crud.ExcelSheetCrudOperation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    // Additional methods for CRUD operations
}

