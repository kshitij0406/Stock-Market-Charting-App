package com.stockApp.Application.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPrice {
    @Id
    Integer companyCode;
    
    String stockExchange;
    Integer pricePerShare;
    Date date;
    Time time;

}
