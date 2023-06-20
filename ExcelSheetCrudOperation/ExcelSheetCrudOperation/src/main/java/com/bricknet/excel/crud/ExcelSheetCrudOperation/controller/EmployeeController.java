package com.bricknet.excel.crud.ExcelSheetCrudOperation.controller;

import com.bricknet.excel.crud.ExcelSheetCrudOperation.entity.Employee;
import com.bricknet.excel.crud.ExcelSheetCrudOperation.entity.ExcelReaderUtil;
import com.bricknet.excel.crud.ExcelSheetCrudOperation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/import")
    public List<Employee> importExcelData() throws IOException {
        String filePath = "path_to_your_excel_file.xlsx";
        List<Employee> employees = ExcelReaderUtil.readExcelData(filePath);
        for (Employee employee : employees) {
            employeeService.saveEmployee(employee);
        }
        return employees;
    }
}

