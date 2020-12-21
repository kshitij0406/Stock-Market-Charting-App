package com.stockApp.Application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPrice {
    @Id
    Integer companyCode;
    
    String stockExchange;
    Integer pricePerShare;
    LocalDate date;
    LocalTime time;

}
