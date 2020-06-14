/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.yosra.Controller;

import com.example.yosra.Exception.ResourceNotFoundException;
import com.example.yosra.Model.Commande;
import com.example.yosra.Repository.CommandeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/commande")
@CrossOrigin("*")
public class CommandeController {
    @Autowired
    CommandeRepository commandeRepository;
    
    
    @GetMapping()
    public List<Commande> list() {
        return (List<Commande>) commandeRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Commande get(@PathVariable Long id) {
        return (Commande) commandeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Commande", "id", id));
    }
    
    @PostMapping
    public Commande post(@RequestBody Commande commande) {
        return commandeRepository.save(commande);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commandeRepository.delete(get(id));
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public String handleError() {
        return "erreur de connexion";
    }
    
}
