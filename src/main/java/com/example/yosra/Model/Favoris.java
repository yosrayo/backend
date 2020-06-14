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
public class Favoris {
         @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     private Long id ;
          @NotNull
	 private long id_produit;
            @NotNull
	 private long id_user;
            @NotNull
     private Float prix;
             @NotNull
      private String photo;
             @NotNull
       private String categorie;
             @NotNull
       private String nom;    
            
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId_produit() {
		return id_produit;
	}
	public void setId_produit(long id_produit) {
		this.id_produit = id_produit;
	}
	
	public long getId_user() {
		return id_user;
	}
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
	
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
         
}
