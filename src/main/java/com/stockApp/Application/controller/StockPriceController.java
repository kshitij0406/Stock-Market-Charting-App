package com.stockApp.Application.controller;

import com.stockApp.Application.dao.ResponseMessage;
import com.stockApp.Application.helper.ExcelHelper;
import com.stockApp.Application.model.StockPrice;
import com.stockApp.Application.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/stockprice/")
public class StockPriceController {

    @Autowired
    StockPriceService stockPriceService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                stockPriceService.save(file);
                System.out.println("pass");
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StockPrice>> getAllTutorials() {
        try {
            List<StockPrice> stockPrices = stockPriceService.getAllStockPrice();

            return new ResponseEntity<>(stockPrices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}