package com.stockApp.Application.service;

import com.stockApp.Application.helper.ExcelHelper;
import com.stockApp.Application.model.StockPrice;
import com.stockApp.Application.repository.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class StockPriceService {
    @Autowired
    StockPriceRepository stockPriceRepository;


    public void save(MultipartFile file) {
        try {
            List<StockPrice> stockPrices = ExcelHelper.excelToStockPrice(file.getInputStream());
            System.out.println("pass 2");
            if(stockPrices.size() == 0){
                System.out.println("stockPrices is empty");
            }
            stockPriceRepository.saveAll(stockPrices);
            System.out.println("pass 2");

        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<StockPrice> getAllStockPrice() {
        return stockPriceRepository.findAll();
    }
}