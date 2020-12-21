package com.stockApp.Application.service;


import com.stockApp.Application.model.Company;
import com.stockApp.Application.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    
    @Autowired
    CompanyRepository companyRepository;
    
    
    public Optional<Company> getCompanyById(int id){
        return companyRepository.findById(id);
    }
    
    public Iterable<Company> getAllCompany(){
        return companyRepository.findAll();
    }
    
    public void addCompany(Company company) {
        companyRepository.save(company);
    }
    
    
    public void updateComapny(Company company, Integer id) {
        Company temp = getCompanyById(id).orElse(null);
        temp.equalto(company);
        companyRepository.save(temp);
    }
    
    public void deleteCompany(Integer id) { companyRepository.deleteById(id);
    }
    
}
