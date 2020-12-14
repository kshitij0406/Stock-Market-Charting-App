package com.stockApp.Application.service;


import com.stockApp.Application.dao.IPODetails;
import com.stockApp.Application.repository.IPODetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IPODetailsService {
    @Autowired
    IPODetailsRepository ipoDetailsRepository;
    
    
    public Optional<IPODetails> getIPOById(int id){
        return ipoDetailsRepository.findById(id);
    }
    
    public Iterable<IPODetails> getAllIPO(){
        return ipoDetailsRepository.findAll();
    }
    
    
    
    public void addIPO(IPODetails ipoDetails) {
        ipoDetailsRepository.save(ipoDetails);
    }
    
    
    public void updateIPO(IPODetails ipoDetails, Integer id) {
        IPODetails temp = getIPOById(id).orElse(null);
        temp.equalto(ipoDetails);
        ipoDetailsRepository.save(temp);
    }
    
    public void deleteIPO(Integer id) { ipoDetailsRepository.deleteById(id);
    }
    
}
