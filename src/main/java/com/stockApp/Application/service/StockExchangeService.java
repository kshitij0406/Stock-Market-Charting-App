package com.stockApp.Application.service;


import com.stockApp.Application.model.StockExchange;
import com.stockApp.Application.repository.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockExchangeService {
    
    @Autowired
    StockExchangeRepository stockExchangeRepository;
    
    public Optional<StockExchange> getStockExchangeById(int id){
        return stockExchangeRepository.findById(id);
    }
    
    public Iterable<StockExchange> getAllStockExchange(){
        return stockExchangeRepository.findAll();
    }
    
    
    public void addStockExchange(StockExchange stockExchange) {
        stockExchangeRepository.save(stockExchange);
    }
    
    
    public void updateStockExchange(StockExchange stockExchange, Integer id) {
        StockExchange temp = getStockExchangeById(id).orElse(null);
        temp.equalto(stockExchange);
        stockExchangeRepository.save(temp);
    }
    
    public void deleteStockExchange(Integer id) { stockExchangeRepository.deleteById(id);
    }
    
}
