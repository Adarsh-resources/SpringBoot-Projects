package com.bricknet.service;


import com.bricknet.dto.EmployeeDTO;
import com.bricknet.dto.LoginDTO;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginMesage loginEmployee(LoginDTO loginDTO);

}
