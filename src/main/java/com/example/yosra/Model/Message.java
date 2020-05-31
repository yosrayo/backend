/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.yosra.Model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author TPC
 */
@Entity
public class Message {
     @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     private Long id ;
     @NotNull
     private Long emetteur;
     @NotNull
     private Long recepteur;
     @NotNull
     private String texte;
     @NotNull
     private Long date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Long emetteur) {
        this.emetteur = emetteur;
    }

    public Long getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Long recepteur) {
        this.recepteur = recepteur;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
     
}
