package org.example.tests.data_driven_testing_excel;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    public static FileInputStream fileInputStream;
    public static FileOutputStream fileOutputStream;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle cellStyle;

    public static int getRowCount(String excelFilePath, String sheetName) throws IOException {
        fileInputStream = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fileInputStream.close();
        return rowCount;
    }

    public static int getColumnCount(String excelFilePath, String sheetName, int rowNum) throws IOException {
        fileInputStream = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
        int columnCount;
        try {
            columnCount = sheet.getRow(rowNum).getLastCellNum();
        } catch (NullPointerException e) {
            columnCount = 0;
        }
        workbook.close();
        fileInputStream.close();
        return columnCount;
    }

    public static String getCellData(String excelFilePath, String sheetName, int rowNum, int colNum) throws IOException {
        fileInputStream = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        String cellData;
        try {
            cell = row.getCell(colNum);
            cellData = cell.toString();
        } catch (NullPointerException e) {
            cellData = "";
        }
        workbook.close();
        fileInputStream.close();
        return cellData;
    }

    public static void setCellData(String excelFilePath, String sheetName, int rowNum, int colNum, String data) throws IOException {
        fileInputStream = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.createCell(colNum);
        cell.setCellValue(data);
        fileOutputStream = new FileOutputStream(excelFilePath);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
        fileInputStream.close();
    }

    public static void fillGreenColor(String excelFilePath, String sheetName, int rowNum, int colNum) throws IOException {
        fileInputStream = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);

        cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);

        fileOutputStream = new FileOutputStream(excelFilePath);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();
    }

    public static void fillRedColor(String excelFilePath, String sheetName, int rowNum, int colNum) throws IOException {
        fileInputStream = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);

        cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);

        fileOutputStream = new FileOutputStream(excelFilePath);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();


    }
}
