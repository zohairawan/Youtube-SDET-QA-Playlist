package org.example.tests.data_driven_testing_excel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExcelWriteDynamicDataTest {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Dynamic Data");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of rows: ");
        int totalRows = Integer.parseInt(scanner.nextLine());
        System.out.print("Number of columns: ");
        int totalColumns = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row <= totalRows; row++) {
            XSSFRow currentRow = sheet.createRow(row);
            for (int column = 0; column < totalColumns; column++) {
                System.out.print("Cell value: ");
                currentRow.createCell(column).setCellValue(scanner.nextLine());
            }
        }

        FileOutputStream excelFile = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\dynamic.xlsx");
        workbook.write(excelFile);
        workbook.close();
        excelFile.close();
        System.out.println("File created...");
    }
}
