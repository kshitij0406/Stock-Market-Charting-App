package com.stockApp.Application.helper;


import com.stockApp.Application.model.StockPrice;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERS = {"Company Code", "Stock Exchange", "Price Per Share(in Rs)", "Date", "Time"};
    static String SHEET = "Sheet1";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            System.out.println("Error here");

            return false;
        }

        return true;
    }

    @Async
    public static List<StockPrice> excelToStockPrice(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            if (sheet == null) {
                System.out.println("Sheet is null");
            }

            Iterator<Row> rows = sheet.iterator();

            List<StockPrice> stockPrices = new ArrayList<StockPrice>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    System.out.println("Skipping Headers");

                    continue;
                }
                System.out.println("Row  " + rowNumber);
                Iterator<Cell> cellsInRow = currentRow.iterator();

                StockPrice stockPrice = new StockPrice();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            System.out.println("Case 0 ");
                            //stockPrice.setCompanyCode((int) currentCell.getNumericCellValue());
                            System.out.println("Case 0 end");
                            break;

                        case 1:
                            System.out.println("Case 1 ");
                            stockPrice.setStockExchange(currentCell.getStringCellValue());
                            break;

                        case 2:
                            System.out.println("Case 2 ");
                            stockPrice.setPricePerShare((float) currentCell.getNumericCellValue());
                            break;

                        case 3:
                            System.out.println("Case 3 ");
                            stockPrice.setDate(currentCell.getLocalDateTimeCellValue().toLocalDate());
                            break;
                        case 4:
                            System.out.println("Case 4 ");
                            stockPrice.setTime(currentCell.getLocalDateTimeCellValue().toLocalTime());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }
                System.out.println("before adding ");
                stockPrices.add(stockPrice);
                System.out.println("After adding ");

            }

            workbook.close();
            System.out.println("pass 4");
            System.out.println(stockPrices);
            return stockPrices;
        } catch (Exception e) {

            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }


    public static List<StockPrice> parseExcelFile(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet("Sheet1");
            Iterator<Row> rows = sheet.iterator();

            List<StockPrice> lstCustomers = new ArrayList<StockPrice>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                StockPrice cust = new StockPrice();

                int cellIndex = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    if (cellIndex == 0) { // ID
                        cust.setCompanyCode((int) currentCell.getNumericCellValue());
                    } else if (cellIndex == 1) { // Name
                        cust.setStockExchange(currentCell.getStringCellValue());
                    } else if (cellIndex == 2) { // Address
                        cust.setPricePerShare((float) currentCell.getNumericCellValue());
                    } else if (cellIndex == 3) { // Age
                        cust.setDate(currentCell.getLocalDateTimeCellValue().toLocalDate());
                    } else if (cellIndex == 4) { // Age
                        cust.setTime(currentCell.getLocalDateTimeCellValue().toLocalTime());
                    }

                    cellIndex++;
                }

                lstCustomers.add(cust);
            }

            // Close WorkBook
            workbook.close();

            return lstCustomers;
        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }
}
