/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.yosra.Model;

/**
 *
 * @author TPC
 */

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 */
@Entity
public class User {
     @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     private Long id ;
       @NotNull
    private String nom;
     @NotNull
    private String prenom;
      @NotNull
    private String telephone;
      @NotNull
    private String zone;
      @NotNull
    private String email;
      @NotNull
    private String mdp;
    @NotNull
    private String grade;
    @NotNull
    private String ville;
    @NotNull
    private String pays;
    @NotNull
    private String adresse;
    
    public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public User(String nom, String prenom, String telephone, String zone, String email, String mdp, String grade,
			String ville, String pays, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.zone = zone;
		this.email = email;
		this.mdp = mdp;
		this.grade = grade;
		this.ville = ville;
		this.pays = pays;
		this.adresse = adresse;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
}