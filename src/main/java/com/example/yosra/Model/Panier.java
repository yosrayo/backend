package com.example.yosra.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;
@Entity
public class Panier {
	  @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long id;
	    @NotNull
	    private String nom_produit;
	     @NotNull
	    private Float prix;
	     @NotNull
	     private String photo;
	     @NotNull
	     private Long id_user;
	     @NotNull
	     private long id_produit;
	     @NotNull
	     private int quantite;
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getNom_produit() {
			return nom_produit;
		}
		public void setNom_produit(String nom_produit) {
			this.nom_produit = nom_produit;
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
		public Long getId_user() {
			return id_user;
		}
		public void setId_user(Long id_user) {
			this.id_user = id_user;
		}

		public int getQuantite() {
			return quantite;
		}

		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}

		public long getId_produit() {
			return id_produit;
		}

		public void setId_produit(long id_produit) {
			this.id_produit = id_produit;
		}
	     
	     

}
