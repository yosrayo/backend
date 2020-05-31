/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.yosra.Controller;

import com.example.yosra.Exception.ResourceNotFoundException;
import com.example.yosra.Model.Favoris;
import com.example.yosra.Repository.FavorisRepository;
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
@RequestMapping("/favoris")
public class FavorisController {
    @Autowired
    FavorisRepository favorisRepository;
    
    
    @GetMapping()
    public List<Favoris> list() {
        return (List<Favoris>) favorisRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Favoris get(@PathVariable Long id) {
        return (Favoris) favorisRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Favoris", "id", id));
    }
    
    @PostMapping
    public Favoris post(@RequestBody Favoris favoris) {
        return favorisRepository.save(favoris);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        favorisRepository.delete(get(id));
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public String handleError() {
        return "erreur de connexion";
    }
    
}
