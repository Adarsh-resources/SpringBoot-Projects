package com.ExcelsheetToDatabase.Service;

import com.ExcelsheetToDatabase.Repository.EmployeeRepo;
import com.ExcelsheetToDatabase.entity.Employee;
import com.ExcelsheetToDatabase.helper.ExcelFileHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {
@Autowired
    private EmployeeRepo employeeRepo ;
    public void save(MultipartFile file) throws IOException {
       List<Employee> employees =  ExcelFileHelper.convertExceltoListofEmployee(file.getInputStream());
       this.employeeRepo.saveAll(employees);
    }
    public List<Employee> getAllProduct(){
return this.employeeRepo.findAll();
    }
    }

}
