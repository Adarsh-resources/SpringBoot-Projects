package org.adarsh.controler;

import org.adarsh.model.Employee;
import org.adarsh.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/import")
    public ResponseEntity<String> importData(@RequestParam("file") String excelFilePath) {
        try {
            List<Employee> employees;
            employees = excelService.importDataFromExcel(excelFilePath);

            // Save employees to the database
            // ... Your database saving logic here

            return ResponseEntity.ok("Data imported successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error importing data from Excel.");
        }
    }
}
