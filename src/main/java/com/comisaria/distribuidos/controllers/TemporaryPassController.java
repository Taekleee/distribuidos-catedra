package com.comisaria.distribuidos.controllers;

import java.util.ArrayList;

import com.comisaria.distribuidos.models.TemporaryPass;
import com.comisaria.distribuidos.repositories.TemporaryPassRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class TemporaryPassController {
    @Autowired
    TemporaryPassRepository temporaryPassRepository;

    @GetMapping("/pass")
    public ArrayList<TemporaryPass> getAllTemporaryPass() {
        return temporaryPassRepository.findAll();
    }

    @PostMapping("/newPass")
    public TemporaryPass createTemporaryPass(@RequestBody TemporaryPass temporaryPass) {
            return temporaryPassRepository.save(temporaryPass);
        
    }

  

}