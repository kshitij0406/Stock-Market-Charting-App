package com.stockApp.Application.controller;


import com.stockApp.Application.dao.Company;
import com.stockApp.Application.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/company/")
public class CompanyController {
    
    @Autowired
    CompanyService companyService;


    @GetMapping("/all")
    public ResponseEntity<Iterable<Company>> getAllCompany() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(companyService.getAllCompany());

    }
    
    
    @GetMapping("/{id}")
    public Optional<Company> getCompanyById(@PathVariable int id){
        
        return companyService.getCompanyById(id);
    }
    

    @PostMapping(value = "/add")
    public void addCompany(@RequestBody Company company){
        companyService.addCompany(company);
    }
    
    
    @PutMapping(value = "/update/{id}")
    public void updateCompany(@RequestBody Company company, @PathVariable int id) {
        companyService.updateComapny(company, id);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void deleteCompany(@PathVariable Integer id) {
        companyService.deleteCompany(id);
    }
    
    
}
