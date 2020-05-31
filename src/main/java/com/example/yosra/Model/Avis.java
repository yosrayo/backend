/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.yosra.Model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author TPC
 */
@Entity
public class Avis {

    @Id
    private Long id;
      @NotNull
        private long id_livreur;
      @NotNull
        private long id_user;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId_livreur() {
        return id_livreur;
    }

    public void setId_livreur(long id_livreur) {
        this.id_livreur = id_livreur;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }
    
}
