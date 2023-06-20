package com.ExcelsheetToDatabase.helper;

import com.ExcelsheetToDatabase.entity.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFileHelper {
//checking type of file
    public static boolean checkExcelFormat(MultipartFile file){
        String contentType = file.getContentType();
        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return true;
        }
else{
    return false;
        }
    }

    public static List<Employee> convertExceltoListofEmployee(InputStream is) {
        List<Employee> list = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("Data");
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();


            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                    Iterator<Cell> cells = row.iterator();
                    int cellid = 0;
                Employee employee = new Employee();

                    while (cells.hasNext()) {
                        Cell cell = cells.next();

                        switch (cellid) {
                            case 0:
                                employee.setEmployeeId((int) cell.getNumericCellValue());
                                break;
                            case 1:
                                employee.setEmployeeName(cell.getStringCellValue());
                                break;
                            case 2:
                                employee.setEmployeeDesignation(cell.getStringCellValue());
                                break;
                            case 3:
                                employee.setEmployeeSalary((int)cell.getNumericCellValue());
                                break;
                            default:
                                break;
                        }
                        cellid++;
                    }
                    list.add(employee);
                }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
