package org.example.tests.data_driven_testing_excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReadDataTest {

    public static void main(String[] args) throws IOException {
        // Open Excel file in reading mode
        FileInputStream excelFile = new FileInputStream("C:\\Users\\Zohair\\Desktop\\AutomationTest.xlsx");
        // Open the workbook from the Excel file
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        // Extract specific sheet from workbook
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int totalRows = sheet.getLastRowNum();
        int totalColumns = sheet.getRow(0).getLastCellNum();
        // Read cells
        System.out.println("Total number of rows: " + totalRows);
        System.out.println("Total number of columns: " + totalColumns);
        for (int row = 0; row <= totalRows; row++) {
            XSSFRow currentRow = sheet.getRow(row);
            for (int column = 0; column < totalColumns; column++) {
                XSSFCell currentRowCell = currentRow.getCell(column);
                System.out.print(currentRowCell.toString() + "\t");
            }
            System.out.println();
        }

        workbook.close();
        excelFile.close();
    }
}