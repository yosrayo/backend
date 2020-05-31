/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.yosra.Controller;

import com.example.yosra.Exception.ResourceNotFoundException;
import com.example.yosra.Model.Avis;
import com.example.yosra.Repository.AvisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TPC
 */
@RestController
@RequestMapping("/avis")
public class AvisController {
    @Autowired
    AvisRepository avisRepository;
    
    
    @GetMapping()
    public List<Avis> list() {
        return (List<Avis>) avisRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Avis get(@PathVariable Long id) {
        return (Avis) avisRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Avis", "id", id));
    }
    
    @PostMapping
    public Avis post(@RequestBody Avis avis) {
        return avisRepository.save(avis);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        avisRepository.delete(get(id));
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public String handleError() {
        return "erreur de connexion";
    }
    
}
