package com.stockApp.Application.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sectors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    String sectorName,brief;
}
