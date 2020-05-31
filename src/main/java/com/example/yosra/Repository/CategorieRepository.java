/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.yosra.Repository;

import com.example.yosra.Model.Categorie;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author TPC
 */
public interface CategorieRepository extends CrudRepository<Categorie, Long> {
    
}
