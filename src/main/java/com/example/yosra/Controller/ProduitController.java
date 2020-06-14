/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.yosra.Controller;

import com.example.yosra.Exception.ResourceNotFoundException;
import com.example.yosra.Model.Produit;
import com.example.yosra.Model.User;
import com.example.yosra.Repository.ProduitRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TPC
 */
@RestController
@RequestMapping("/produit")
@CrossOrigin("*")
public class ProduitController {
    @Autowired
    ProduitRepository produitRepository;
    
    
    @GetMapping()
    public List<Produit> list() {
        return (List<Produit>) produitRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Produit get(@PathVariable Long id) {
        return (Produit) produitRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produit", "id", id));
    }
    
    @PostMapping
    public Produit post(@RequestBody Produit produit) {
        return produitRepository.save(produit);
    }
    
    
    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable(value = "id") Long produitId,  @RequestBody Produit produitDetails) {

       Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new ResourceNotFoundException("Produit", "id", produitId));

       produit.setNom_produit(produitDetails.getNom_produit());
       produit.setPhoto(produitDetails.getPhoto()); 
       produit.setPrix(produitDetails.getPrix());
       produit.setQuantite(produitDetails.getQuantite());
      
       Produit updatedProduit = produitRepository.save(produit);
       return updatedProduit;
    }  
    
    
    @DeleteMapping("/{id}")
    public List<Produit> cancelRegistration(@PathVariable long id) {
    	produitRepository.deleteById(id);
        return (List<Produit>) produitRepository.findAll();
    }
 
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public String handleError() {
        return "erreur de connexion";
    }
     
}
