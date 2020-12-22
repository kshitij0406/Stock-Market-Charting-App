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
public class StockPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;


    Integer companyCode;
    String stockExchange;
    Float pricePerShare;
    LocalDate date;
    LocalTime time;


}
