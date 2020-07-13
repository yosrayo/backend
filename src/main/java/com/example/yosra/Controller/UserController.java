/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.yosra.Controller;

import com.example.yosra.Exception.ResourceNotFoundException;
import com.example.yosra.Model.Produit;
import com.example.yosra.Model.User;
import com.example.yosra.Repository.UserRepository;

import java.awt.PageAttributes.MediaType;
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

/**
 *
 * @author TPC
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserRepository userRepository;
    
    
    @GetMapping()
    public List<User> list() {
        return (List<User>) userRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return (User) userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

@GetMapping("affichage")
		public List<User>LoginUser() {

	 return (List<User>) userRepository.findAll();
	 
	 }



@GetMapping("grade/{grade}")
public List<User> GradeUser(@PathVariable String grade) {

return userRepository.findByGrade(grade);

}
    

    @PostMapping
    public User post(@RequestBody User user) {
        return userRepository.save(user);
    }

    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId,  @RequestBody User userDetails) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setNom(userDetails.getNom());
        user.setPrenom(userDetails.getPrenom());
        user.setPays(userDetails.getPays());
        user.setAdresse(userDetails.getAdresse());
        user.setPrenom(userDetails.getPrenom());
        user.setMdp(userDetails.getMdp());
        user.setEmail(userDetails.getEmail());
        user.setGrade(userDetails.getGrade());
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }
    
    
    
    @DeleteMapping("/{id}")
    public List<User> cancelRegistration(@PathVariable long id) {
    	userRepository.deleteById(id);
        return (List<User>) userRepository.findAll();
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public String handleError() {
        return "erreur de connexion";
    }
    
    
    
    
    


    
    
    
    
    
    
    
    
    
    
}
