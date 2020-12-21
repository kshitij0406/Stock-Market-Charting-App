package com.stockApp.Application.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPODetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    String companyName, stockExchange;
    LocalDate date;
    LocalTime time;
    Integer totalNumberOfShares;
    Float pricePerShare;
    
    public void equalto(IPODetails i) {
        this.companyName = i.companyName;
        this.date = i.date;
        this.pricePerShare = i.pricePerShare;
        this.time = i.time;
        this.stockExchange = i.stockExchange;
        this.totalNumberOfShares = i.totalNumberOfShares;
        
    }
}
