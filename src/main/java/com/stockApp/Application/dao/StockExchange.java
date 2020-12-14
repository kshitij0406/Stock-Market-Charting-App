package com.stockApp.Application.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class StockExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    String stockExchangeName, brief, contactAddress, remarks;
    
    
    public void equalto(StockExchange s){
        this.brief = s.brief;
        this.contactAddress = s.contactAddress;
        this.stockExchangeName = s.stockExchangeName;
        this.remarks = s.remarks;
    }
    
}
