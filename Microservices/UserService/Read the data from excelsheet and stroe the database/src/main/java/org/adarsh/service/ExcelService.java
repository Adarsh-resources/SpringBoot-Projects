package org.adarsh.service;

import org.adarsh.model.Employee;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelService {

    public List<Employee> importDataFromExcel(String excelFilePath) throws Exception {
        List<Employee> employees = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(excelFilePath);
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming data is present in the first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip the header row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Employee employee = new Employee();
                employee.setFirstName(row.getCell(0).getStringCellValue());
                employee.setLastName(row.getCell(1).getStringCellValue());
                employee.setAge((int) row.getCell(2).getNumericCellValue());
                employees.add(employee);
            }
        }

        return employees;
    }
}

