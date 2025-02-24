package org.example.tests.data_driven_testing_excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtilz {

    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private String excelFilePath;
    private String sheetName;

    public ExcelUtilz(String excelFilePath, String sheetName) throws IOException {
        this.excelFilePath = excelFilePath;
        this.sheetName = sheetName;
        fileInputStream = new FileInputStream(excelFilePath);
//        fileOutputStream = new FileOutputStream(excelFilePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public int getColumnCount(int rowNum) {
        return sheet.getRow(rowNum).getLastCellNum();
    }

    public String getCellData(int rowNum, int colNum) {
        return sheet.getRow(rowNum).getCell(colNum).toString();
    }

    public void setCellData(int rowNum, int colNum, String data) throws IOException {
        XSSFCell cell = sheet.getRow(rowNum).createCell(colNum);
        cell.setCellValue(data);
        fileOutputStream = new FileOutputStream(excelFilePath);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    public void close() throws IOException {
        workbook.close();
        fileInputStream.close();
    }


}
