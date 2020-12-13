package com.stockApp.Application.dao;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
public class IPODetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    String companyName, stockExchange;
    Date date;
    Time time;
    Integer totalNumberOfShares;
    Float pricePerShare;
   
}
