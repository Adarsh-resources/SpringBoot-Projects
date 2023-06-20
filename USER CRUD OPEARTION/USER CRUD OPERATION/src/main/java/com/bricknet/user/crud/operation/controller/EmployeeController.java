package com.bricknet.user.crud.operation.controller;

import com.bricknet.user.crud.operation.entity.Employee;
import com.bricknet.user.crud.operation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @PostMapping("/addListOfEmployee")
    public List<Employee> addEmployee(@RequestBody List<Employee> employees) {
        return service.saveEmployee(employees);
    }

    @GetMapping("/allEmployee")
    public List<Employee> findAllEmployee() {
        return service.getEmployee();
    }

    @GetMapping("/employeeById/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @GetMapping("/employee/{name}")
    public Employee findEmployeeByName(@PathVariable String name) {
        return service.getEmployeeByName(name);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}
