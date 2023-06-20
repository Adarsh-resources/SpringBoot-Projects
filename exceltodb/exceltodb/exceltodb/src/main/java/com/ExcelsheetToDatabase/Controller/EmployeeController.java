package com.ExcelsheetToDatabase.Controller;

import com.ExcelsheetToDatabase.Service.EmployeeService;
import com.ExcelsheetToDatabase.entity.Employee;
import com.ExcelsheetToDatabase.helper.ExcelFileHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class EmployeeController {
@Autowired
    private EmployeeService employeeService;
@PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException {
    if(ExcelFileHelper.checkExcelFormat(file)){
    this.employeeService.save(file);
    return ResponseEntity.ok(Map.of("message","File is uploaded and data is saved to db"));
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only");
}
@GetMapping("/employee")
    public List<Employee> getAllProduct(){
    return this.employeeService.getAllProduct();

//    to find the user by id
// @GetMapping("/userid")
//         public List<Employee>get

    }

}

