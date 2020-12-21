package com.stockApp.Application.controller;


import com.stockApp.Application.model.IPODetails;
import com.stockApp.Application.service.IPODetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ipo/")
public class IPODetailsController {
    
    @Autowired
    IPODetailsService ipoDetailsService;
    
    
    
    @GetMapping("/all")
    public Iterable<IPODetails> getAllIPO(){
        
        return ipoDetailsService.getAllIPO();
    }
    
    
    @GetMapping("/{id}")
    public Optional<IPODetails> getIPOById(@PathVariable int id){
        
        return ipoDetailsService.getIPOById(id);
    }
    
    @PostMapping(value = "/add")
    public void addIPO(@RequestBody IPODetails ipoDetails){
        ipoDetailsService.addIPO(ipoDetails);
    }
    
    
    @PutMapping(value = "/update/{id}")
    public void updateIPO(@RequestBody IPODetails ipoDetails, @PathVariable int id) {
        ipoDetailsService.updateIPO(ipoDetails, id);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void deleteIPO(@PathVariable Integer id) {
        ipoDetailsService.deleteIPO(id);
    }
    
}
