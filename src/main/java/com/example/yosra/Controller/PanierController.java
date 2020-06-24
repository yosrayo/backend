package com.example.yosra.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.example.yosra.Exception.ResourceNotFoundException;
import com.example.yosra.Model.Panier;
import com.example.yosra.Model.Produit;
import com.example.yosra.Model.User;
import com.example.yosra.Repository.PanierRepository;
import com.example.yosra.Repository.ProduitRepository;

@RestController
@RequestMapping("/panier")
@CrossOrigin("*")
public class PanierController {
	
	 @Autowired
	    PanierRepository panierRepository;
	    
	    
	    @GetMapping()
	    public List<Panier> list() {
	        return (List<Panier>) panierRepository.findAll();
	    }
	    
	    @GetMapping("/{id}")
	    public Panier get(@PathVariable Long id) {
	        return (Panier) panierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Panier", "id", id));
	    }
	    
	    @PostMapping
	    public Panier post(@RequestBody Panier panier) {
	        return panierRepository.save(panier);
	    }
	    
	    @PutMapping("/{id}")
	    public Panier updatePanier(@PathVariable(value = "id") Long panierId,  @RequestBody Panier panierDetails) {

	        Panier panier = panierRepository.findById(panierId)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "id", panierId));

	       panier.setQuantite(panierDetails.getQuantite());
	       panier.setPhoto(panierDetails.getPhoto());
	       panier.setId_user(panierDetails.getId_user());
	       panier.setPrix(panierDetails.getPrix());
	       panier.setNom_produit(panierDetails.getNom_produit());
	        Panier updatedPanier = panierRepository.save(panier);
	        return updatedPanier;
	    }
	    
	    @DeleteMapping("/{id}")
	    public List<Panier> cancelRegistration(@PathVariable long id) {
	    	panierRepository.deleteById(id);
	        return (List<Panier>) panierRepository.findAll();
	    }
	    
	    @ExceptionHandler(Exception.class)
	    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
	    public String handleError() {
	        return "erreur de connexion";
	    }
	  

}
