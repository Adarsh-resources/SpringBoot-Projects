package com.bricknet.excel.crud.ExcelSheetCrudOperation.entity;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtil {

    public static List<Employee> readExcelData(String filePath) throws IOException {
        List<Employee> employees = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Employee employee = new Employee();
            employee.setId(row.getCell(0).getStringCellValue());
            employee.setName(row.getCell(1).getStringCellValue());
            employee.setSalary((int) row.getCell(2).getNumericCellValue());
            employees.add(employee);
        }

        workbook.close();
        fileInputStream.close();

        return employees;
    }
}

