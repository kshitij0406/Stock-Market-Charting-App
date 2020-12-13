package com.stockApp.Application.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
public class StockPrice {
    @Id
    Integer companyCode;
    
    String stockExchange;
    Integer pricePerShare;
    Date date;
    Time time;

}
