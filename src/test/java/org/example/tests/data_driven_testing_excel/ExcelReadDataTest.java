package org.example.tests.data_driven_testing_excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReadDataTest {

    public static void main(String[] args) {
        FileInputStream excelFile = null;
        XSSFWorkbook workbook = null;
        // Open Excel file in reading mode
        try {
            excelFile = new FileInputStream("C:\\Users\\Zohair\\Desktop\\AutomationTest.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Open the workbook from the Excel file
        try {
            workbook = new XSSFWorkbook(excelFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // Count how many rows/columns are present in the Sheet
        int totalRows = sheet.getLastRowNum();
        int totalColumns = sheet.getRow(1).getLastCellNum();

        // Read cells
        System.out.println("Total number of rows: " + totalRows);
        System.out.println("Total number of columns: " + totalColumns);
        for (int row = 0; row <= totalRows; row++) {
            XSSFRow currentRow = sheet.getRow(row);
            for (int column = 0; column < totalColumns; column++) {
                XSSFCell currentRowCell = currentRow.getCell(column);
                System.out.print(currentRowCell.toString() + " ");
            }
            System.out.println();
        }

        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}