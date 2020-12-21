package com.stockApp.Application.controller;


import com.stockApp.Application.model.StockExchange;
import com.stockApp.Application.service.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/stockexchange/")
public class StockExchangeController {
    
    @Autowired
    StockExchangeService stockExchangeService;
    
    @GetMapping("/all")
    public Iterable<StockExchange> getAllStockExchange(){
        return stockExchangeService.getAllStockExchange();
    }
    
    @GetMapping("/{id}")
    public Optional<StockExchange> getStockExchangeById(@PathVariable int id){
        
        return stockExchangeService.getStockExchangeById(id);
    }
    
    @PostMapping(value = "/add")
    public void addStockExchange(@RequestBody StockExchange stockExchange){
        stockExchangeService.addStockExchange(stockExchange);
    }
    
    @PutMapping(value = "/update/{id}")
    public void updateStockExcange(@RequestBody StockExchange stockExchange, @PathVariable int id) {
        stockExchangeService.updateStockExchange(stockExchange, id);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void deleteStockExchange(@PathVariable Integer id) {
        stockExchangeService.deleteStockExchange(id);
    }
}
