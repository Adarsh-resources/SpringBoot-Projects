package com.ExcelsheetToDatabase.Repository;

import com.ExcelsheetToDatabase.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
